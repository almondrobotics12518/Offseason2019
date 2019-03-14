package org.firstinspires.ftc.teamcode.drive;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.hardware.LynxOptimizedI2cFactory;
import org.openftc.revextensions2.ExpansionHubEx;
import org.openftc.revextensions2.ExpansionHubMotor;
import org.openftc.revextensions2.RevExtensions2;

import java.util.Arrays;
import java.util.List;

public class MecanumDrive {

    private BNO055IMU imu;
    private ExpansionHubEx hub1;
    private ExpansionHubMotor leftFront,leftBack,rightFront,rightBack;
    private List<ExpansionHubMotor> motors;

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


    }
}
