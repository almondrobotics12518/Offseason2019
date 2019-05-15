package org.firstinspires.ftc.teamcode.opmodes.test;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.opmodes.AlmondLinear;
import org.firstinspires.ftc.teamcode.subsystems.Detector;

@Autonomous(name="Auto Camera Crop Test",group="test")
public class AutoSampleTest extends AlmondLinear {
    Detector detector;
    public int bottom = 100;
    public int top = bottom+200;
    public void runOpMode() throws  InterruptedException {



        detector = new Detector(hardwareMap);
        detector.setCrop(top,0,bottom,0);
        while(!isStarted() && !isStopRequested()){
            telemetry.addLine("Status -- Init Loop...");
            telemetry.update();
        }

        if(!isStopRequested()){
            return;
        }

        detector.enable();
        while(!isStopRequested()){

            if(gamepad1.a){
                bottom++;
            }

            if(gamepad1.b){
                bottom--;
            }

            detector.setCrop(top,0,bottom,0);

            if(gamepad1.left_bumper){
                detector.disable();

            }

            telemetry.addLine("Detector Test - Press left bumper to disable detector");
            telemetry.addLine("Crop top and bottom "+top +", "+bottom);
            telemetry.update();
        }
        detector.disable();
    }
}
