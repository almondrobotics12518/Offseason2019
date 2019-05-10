package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class TeamMarker {
    public Servo tm;
    public TeamMarker(HardwareMap hardwareMap){
        tm = hardwareMap.servo.get("tm");
    }

    public void init(){
        tm.setPosition(0.4);
    }

    public void deploy(){
        tm.setPosition(1);
    }
}
