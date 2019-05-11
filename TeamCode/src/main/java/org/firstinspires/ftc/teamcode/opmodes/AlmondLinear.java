package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.subsystems.Detector;
import org.firstinspires.ftc.teamcode.subsystems.MecanumDrive;
import org.firstinspires.ftc.teamcode.subsystems.TeamMarker;

public abstract class AlmondLinear extends LinearOpMode{
    public MecanumDrive drive;
    public TeamMarker teamMarker;
    public Detector detector;

    public void initialize(){

        teamMarker = new TeamMarker(hardwareMap);
        drive = new MecanumDrive(hardwareMap);
        detector = new Detector(hardwareMap);

        teamMarker.init();
    }


}
