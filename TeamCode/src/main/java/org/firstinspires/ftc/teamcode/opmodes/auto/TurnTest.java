package org.firstinspires.ftc.teamcode.opmodes.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.teamcode.opmodes.AlmondLinear;

@Autonomous(name="Gyro Test",group = "test")
public class TurnTest extends AlmondLinear {
    public void runOpMode() throws InterruptedException{
        hardwareMap();
        initImu();
        waitForStart();
        turn(90);
        turn(-180);
        turn(90);
        turn(50);
        turn(-50);
        turn(50);
        turn(-50);

        while(isStarted()&&!isStopRequested()){
            telemetry.addLine(""+imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES));
            telemetry.update();
        }
    }
}
