package org.firstinspires.ftc.teamcode.opmodes.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.control.motion.PID;
import org.firstinspires.ftc.teamcode.opmodes.AlmondLinear;

@Autonomous(name = "Crater Side", group = "auto")
public class CraterSideNew extends AlmondLinear {
    public void runOpMode() throws InterruptedException {

        hardwareMap();
        teamMarker.setPosition(0.2);
        waitForStart();

        while (opModeIsActive() && isRunning) {
            unlatch();


            detectorEnable();

            PIDDrive(-100, -100, -100, -100);
            setPower(-0.5,0.5,0.5,-0.5);
            sleep(800);
            setPower(0,0,0,0);

            PIDDrive(150, 150, 150, 150);

            initImu();


            /*
             * Sampling code that scans and returns a position
             * for the mineral.
             *
             */

            globalAngle -= 5;
            if (detector.isFound() && detector.getFoundRect().area()>4000 && detector.getFoundRect().x>200) {
                detector.disable();
                turn(90); // turns towards gold
                driveToDistance(20); // pushes gold
                driveToDistance(-10); // goes away from gold
                turn(-80); // turns towards  side

            } else {
                turn(30); // turns towards position 2
                sleep(300);
                if(detector.isFound() && detector.getFoundRect().area()>4000){
                    detector.disable();
                    turn(60); // face mid
                    driveToDistance(8); // goes mid way
                    turn(65); // turns to 2nd position
                    driveToDistance(20); // pushes gold
                    driveToDistance(-20); //  goes back
                    turn(-145); // turns towards side
                    // an attempt
                    //turn(120);
                    //driveToDistance(24);
                    //driveToDistance(-10);
                    //turn(-110);
                } else {
                    detector.disable();
                    turn(60); // face mid
                    driveToDistance(8); //goes mid way
                    turn(-60); // turns to 3rd position
                    driveToDistance(20); //pushes gold
                    driveToDistance(-20); // goes back
                    turn(-20); // turns to side
                    // an attempt
                    //turn(-30);
                    //turn(75);
                    //driveToDistance(24);
                    //driveToDistance(-10);
                    //turn(-130);

                }
            }

            /*
             * Turns based on the position returned by sampling
             * above.
             */
            driveToDistance(45);
            turn(-50);

            setPower(-0.5,0.5,0.5,-0.5);
            sleep(500);
            setPower(0,0,0,0);

            driveToDistance(32);
            turn(90);
            teamMarker.setPosition(0.8);
            sleep(300);
            turn(80);
            driveToDistance(59);

            detector.disable();
            isRunning = false;
        }
    }
}