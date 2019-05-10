package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.subsystems.MecanumDrive;

public class AlmondLinear extends LinearOpMode{
    public MecanumDrive drive;

    public void runOpMode() throws InterruptedException{
        drive = new MecanumDrive(hardwareMap);

        waitForStart();
        drive.setTargetAngle(90);
        drive.update();
        while(!isStopRequested()&&drive.currentAngle-90>0.3){
            drive.turn();
            drive.update();

        }

    }

}
