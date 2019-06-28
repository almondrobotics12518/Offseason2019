package org.firstinspires.ftc.teamcode.opmodes.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.opmodes.AlmondLinear;

@Autonomous(name = "Depot Side New",group = "auto")
public class DepotSide extends AlmondLinear {
    public void runOpMode() throws InterruptedException {
        hardwareMap();
        setModeRunUsingEncoders();
        teamMarker.setPosition(0.2);
        mineralPosition position;

        waitForStart();
        unlatch();
        detectorEnable();
        PIDDrive(-100, -100, -100, -100);
        initImu();
        setPower(-0.5,0.5,0.5,-0.5);
        int target = leftFront.getCurrentPosition() + 300;
        sleep(500);
        setPower(0,0,0,0);
        PIDDrive(150, 150, 150, 150);



        /*
         * Sampling code that scans and returns a position
         * for the mineral.
         *
         */

        if (detector.isFound()&& detector.getFoundRect().area()>4000 && detector.getFoundRect().x>200) {
            detector.disable();
            turn(90);
            driveToDistance(22);
            driveToDistance(-12);
            turn(-80);

        } else {
            turn(30);
            if(detector.isFound()&&detector.getFoundRect().area()>4000){
                detector.disable();
                turn(60);
                driveToDistance(7);
                turn(50);
                driveToDistance(20);
                driveToDistance(-20);
                turn(-130);
            } else {
                detector.disable();
                turn(60);
                driveToDistance(7);
                turn(-50);
                driveToDistance(20);
                driveToDistance(-20);
                turn(-30);

            }
        }

        /*
         * Turns based on the position returned by sampling
         * above.
         */

        driveToDistance(45);
        turn(-55);
        setPower(-0.5,0.5,0.5,-0.5);
        sleep(800);
        setPower(0,0,0,0);
        turn(0);
        driveToDistance(-55);


        turn(-90);
        teamMarker.setPosition(0.8);
        sleep(300);
        turn(90);
        driveToDistance(65);







    }
}