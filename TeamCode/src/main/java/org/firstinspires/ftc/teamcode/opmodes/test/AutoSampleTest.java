package org.firstinspires.ftc.teamcode.opmodes.test;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.opmodes.AlmondLinear;
import org.firstinspires.ftc.teamcode.subsystems.Detector;

@Autonomous(name="Auto Sampling Test",group="test")
public class AutoSampleTest extends AlmondLinear {
    Detector detector;
    public int bottom = 100;
    public void runOpMode() throws  InterruptedException {

        detector = new Detector(hardwareMap);
        detector.setCrop(0,0,bottom,0);
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

            detector.setCrop(0,0,bottom,0);

            if(gamepad1.left_bumper){
                detector.disable();

            }
        }
        detector.disable();
    }
}
