package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.teamcode.math.Pose;
import org.firstinspires.ftc.teamcode.betterI2C.LynxOptimizedI2cFactory;
import org.openftc.revextensions2.ExpansionHubEx;
import org.openftc.revextensions2.ExpansionHubMotor;
import org.openftc.revextensions2.RevBulkData;
import org.openftc.revextensions2.RevExtensions2;

import java.util.Arrays;
import java.util.List;

import static org.firstinspires.ftc.teamcode.subsystems.DriveConstants.INCHES_PER_TICK;

public class MecanumDrive {

    Pose lastPose = new Pose(0,0,0);
    Pose currentPose = new Pose(0,0,0);

    double slideKp = 0.001;

    double turnKp = 0.02;
    double turnKd = 0.001;

    double turnError = 0;
    double turnLastError = 0;
    double turnPower = 0;

    double lastAngle = 0;
    public double currentAngle = 0;
    double targetAngle;

    boolean isClockwise;

    private BNO055IMU imu;
    private ExpansionHubEx hub1;
    private ExpansionHubMotor leftFront,leftBack,rightFront,rightBack;
    private List<ExpansionHubMotor> motors;

    public RevBulkData bulkData1;

    public double lastLfEnc;
    public double lastLbEnc;
    public double lastRfEnc;
    public double lastRbEnc;

    double tarLf;
    double tarLb;
    double tarRf;
    double tarRb;

    public double lfEnc;
    public double lbEnc;
    public double rfEnc;
    public double rbEnc;

    double lfEncOffset=0;
    double lbEncOffset=0;
    double rfEncOffset=0;
    double rbEncOffset=0;

    public MecanumDrive(HardwareMap hardwareMap){

        RevExtensions2.init();
        imu = LynxOptimizedI2cFactory.createLynxEmbeddedImu(hub1.getStandardModule(), 0);
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit = BNO055IMU.AngleUnit.RADIANS;
        imu.initialize(parameters);

        leftFront = hardwareMap.get(ExpansionHubMotor.class, "LeftFront");
        leftBack = hardwareMap.get(ExpansionHubMotor.class, "LeftBack");
        rightBack = hardwareMap.get(ExpansionHubMotor.class, "RightBack");
        rightFront = hardwareMap.get(ExpansionHubMotor.class, "RightFront");

        motors = Arrays.asList(leftFront, leftBack, rightBack, rightFront);

        for(ExpansionHubMotor motor : motors){
            motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        }

        rightFront.setDirection(DcMotorSimple.Direction.REVERSE);
        rightBack.setDirection(DcMotorSimple.Direction.REVERSE);

        updateBulkData();
        updateEncoders();
        updateAngle();
    }

    public void setTargetForward(double inches){
        double ticks = inches / INCHES_PER_TICK;
        setTargetEncoder(ticks,ticks,ticks,ticks);
    }

    public void setPower(double lf, double lb, double rf, double rb){
        leftFront.setPower(lf);
        leftBack.setPower(lb);
        rightFront.setPower(rf);
        rightBack.setPower(rb);
    }

    public void setTargetEncoder(double lf, double lb, double rf, double rb){
        tarLb = lb;
        tarLf = lf;
        tarRf = rf;
        tarRb = rb;
    }
    
    public void moveToPosition(){
        setPower(((tarLf - lfEnc)*slideKp),((tarLb - lbEnc)*slideKp),((tarRf - rfEnc)*slideKp),((tarRb - rbEnc)*slideKp));
    }

    public void setTargetAngle(double angle){
        targetAngle = angle;
        double errorR = (targetAngle - currentAngle+360)%360;
        double errorL = (currentAngle - targetAngle+360)%360;

        if(errorR>errorL){
            isClockwise = false;
        } else {
            isClockwise = true;
        }
    }

    public void turnToAngle(){

        if(!isClockwise){
            turnError = (((currentAngle-targetAngle)%360)+360)%360;

            turnPower = (turnError * turnKp) + (turnLastError * turnKd);
            setPower(turnPower,turnPower,-turnPower,-turnPower);

            turnLastError = turnError;
        } else {
            turnError = (((targetAngle-currentAngle)%360)+360)%360;

            turnPower = (turnError * turnKp) + (turnLastError * turnKd);
            setPower(-turnPower,-turnPower,turnPower,turnPower);

            turnLastError = turnError;
        }
    }

    public RevBulkData getBulkData(ExpansionHubEx hub){
        return hub.getBulkInputData();
    }

    public void updateBulkData(){
        bulkData1 = getBulkData(hub1);
    }

    public void updateEncoders(){
        lastLfEnc = lfEnc;
        lastLbEnc = lbEnc;
        lastRbEnc = rbEnc;
        lastRfEnc = rfEnc;

        lfEnc = bulkData1.getMotorCurrentPosition(0)-lfEncOffset;
        lbEnc = bulkData1.getMotorCurrentPosition(1)-lbEncOffset;
        rfEnc = bulkData1.getMotorCurrentPosition(2)-rfEncOffset;
        rbEnc = bulkData1.getMotorCurrentPosition(3)-rbEncOffset;
    }

    public double getCurrentAngle(){
        return (imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES).firstAngle*-1)+180;
    }

    public void updateAngle(){
        lastAngle = currentAngle;
        currentAngle = getCurrentAngle();
    }

    public void updatePose(){
        lastPose = currentPose;
        double dR = ((rfEnc + rbEnc) - (lastRfEnc+lastRbEnc))*INCHES_PER_TICK/2;
        double dL = ((lfEnc + lbEnc)-(lastLfEnc + lastLbEnc))*INCHES_PER_TICK/2;
        double dC = (dL+dR)/2;
        double deltaTheta = currentAngle - lastAngle;
        double deltaX = lastPose.x + (dC * Math.cos(deltaTheta));
        currentPose = new Pose(lastPose.x + (dC * Math.cos(deltaTheta)),lastPose.y+(dC * Math.sin(deltaTheta)),currentAngle);
    }

    public void softResetEncoders(){
        lfEncOffset = lfEnc;
        lbEncOffset = lbEnc;
        rfEncOffset = rfEnc;
        rbEncOffset = rbEnc;
    }

    public Pose getCurrentPose(){
        return currentPose;
    }

    public void update(){
        updateBulkData();
        updateEncoders();
        updateAngle();
        updatePose();
    }

}
