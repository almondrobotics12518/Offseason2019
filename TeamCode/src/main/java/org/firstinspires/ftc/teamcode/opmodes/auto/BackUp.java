package org.firstinspires.ftc.teamcode.opmodes.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.opmodes.AlmondLinear;

@Autonomous(name="Back-Up",group="Auto")
public class BackUp extends AlmondLinear {
    public void runOpMode() throws InterruptedException {
        hardwareMap();
        waitForStart();
        unlatch();

    }
}