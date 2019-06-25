package org.firstinspires.ftc.teamcode.opmodes.test;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.opmodes.AlmondLinear;
import org.firstinspires.ftc.teamcode.subsystems.Detector;
import org.opencv.core.Point;


public class AutoSampleTest {
    /*
    Detector detector;
    public int bottom = 100;
    public int top = bottom+200;
    public void runOpMode() throws  InterruptedException {



        detector = new Detector(hardwareMap);

        while(!isStarted() && !isStopRequested()){
            telemetry.addLine("Status -- Init Loop...");
            telemetry.update();
        }

        if(isStopRequested()){
            return;
        }

        waitForStart();

        detector.enable();
        while(opModeIsActive()){


            if(gamepad1.left_bumper){
                detector.disable();

            }

            telemetry.addLine("Detector Test - Press left bumper to disable detector");
            telemetry.addLine("CurrentPos"+detector.detector.getFoundRect().x+", "+detector.detector.getFoundRect().y);
            telemetry.update();
        }
        detector.disable();
    }*/
}
