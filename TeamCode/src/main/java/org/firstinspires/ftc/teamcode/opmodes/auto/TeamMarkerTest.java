package org.firstinspires.ftc.teamcode.opmodes.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.opmodes.AlmondLinear;

@Autonomous(name="Team Marker Test",group="test")
public class TeamMarkerTest extends AlmondLinear {
    public void runOpMode() throws InterruptedException{
        hardwareMap();
        waitForStart();
        teamMarker.setPosition(1);
        sleep(1000);
        teamMarker.setPosition(0.9);
        sleep(1000);
        teamMarker.setPosition(0.8);
        sleep(1000);
        teamMarker.setPosition(0.7);
        sleep(1000);
        teamMarker.setPosition(0.6);
        sleep(1000);
        teamMarker.setPosition(0.5);
        sleep(1000);
        teamMarker.setPosition(0.4);
        sleep(1000);
        teamMarker.setPosition(0.3);
        sleep(1000);
        teamMarker.setPosition(0.2);
        sleep(1000);
        teamMarker.setPosition(0.1);
        sleep(1000);
        teamMarker.setPosition(0);
        sleep(1000);
    }
}
