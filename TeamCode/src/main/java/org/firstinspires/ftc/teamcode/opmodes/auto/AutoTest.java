package org.firstinspires.ftc.teamcode.opmodes.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.opmodes.AlmondLinear;
import org.firstinspires.ftc.teamcode.subsystems.Detector;

@Autonomous(name="First Auto Test",group="auto")
public class AutoTest extends AlmondLinear{

    private Detector.MineralPosition position;

    public void runOpMode() throws InterruptedException {
        /*
        initialize();
        detector.enable();
        teamMarker.init();
        while(!isStarted()&&!isStopRequested()){
            position = detector.getMineralPosition();
            telemetry.addData("Mineral Position", position);
            telemetry.update();
        }*/
    }

}
