package org.firstinspires.ftc.teamcode.opmodes.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.opmodes.AlmondLinear;

@Autonomous(name="Camera Test",group="test")
public class CameraTest extends AlmondLinear {
    public void runOpMode() throws InterruptedException {
        detectorEnable();
        while(!isStarted()&&!isStopRequested()){
            telemetry.addLine("Camera x and y: "+detector.getFoundRect().x+", "+detector.getFoundRect().y);
            telemetry.addLine("Area: "+detector.getFoundRect().area());
            telemetry.update();
        }
        waitForStart();


    }
}
