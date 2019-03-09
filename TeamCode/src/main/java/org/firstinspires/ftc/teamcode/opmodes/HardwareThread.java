package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.hardware.LynxOptimizedI2cFactory;
import org.openftc.revextensions2.ExpansionHubEx;
import org.openftc.revextensions2.ExpansionHubMotor;
import org.openftc.revextensions2.RevBulkData;
import org.openftc.revextensions2.RevExtensions2;

public class HardwareThread extends Thread{


    public boolean isRunning;

    public RevBulkData bulkData;
    private ExpansionHubMotor leftFront,leftBack,rightFront,rightBack;
    private ExpansionHubEx expansionHub1;
    private BNO055IMU imu;
    private Telemetry telemetry;


    public HardwareThread(Telemetry telemetry, HardwareMap hardwareMap){
        RevExtensions2.init();
        expansionHub1 = hardwareMap.get(ExpansionHubEx.class, "Expansion Hub 2");
        leftFront = (ExpansionHubMotor) hardwareMap.dcMotor.get("leftFront");
        leftBack = (ExpansionHubMotor) hardwareMap.dcMotor.get("leftBack");
        rightFront = (ExpansionHubMotor) hardwareMap.dcMotor.get("rightFront");
        rightBack = (ExpansionHubMotor) hardwareMap.dcMotor.get("rightBack");

        imu = LynxOptimizedI2cFactory.createLynxEmbeddedImu(expansionHub1.getStandardModule(), 0);
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        imu.initialize(parameters);

        this.telemetry = telemetry;

    }

    public void run(){
        while(isRunning){
            bulkData = expansionHub1.getBulkInputData();
            telemetry.addLine("Does telemetry work? POGGERS");
            telemetry.update();
        }
        telemetry.addLine("Successfully exited.");
        telemetry.update();
    }

    public void setIsRunning(boolean isRunning){this.isRunning = isRunning;}






}
