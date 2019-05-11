package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Hang {

    int latchTicks;
    int unlatchTicks;
    int prepareTicks;


    DcMotor hang;

    public Hang(HardwareMap hardwareMap){
        hang = hardwareMap.dcMotor.get("LScrew");
        hang.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void unlatch(){
        hang.setTargetPosition(hang.getCurrentPosition()-12500);
        hang.setPower(1);
    }

    public void latch(){
        hang.setTargetPosition(hang.getCurrentPosition()+12500);
        hang.setPower(1);
    }

    public void prepare(){
        //TODO
        //Add position for prep at end of auto
    }
}
