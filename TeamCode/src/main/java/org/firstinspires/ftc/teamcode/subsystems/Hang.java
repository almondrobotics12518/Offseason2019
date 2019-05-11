package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Hang {

    int latchTicks = 12500;
    int unlatchTicks = 12500;
    int prepareTicks = 0;


    DcMotor hang;

    public Hang(HardwareMap hardwareMap){
        hang = hardwareMap.dcMotor.get("LScrew");
        hang.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void unlatch(){
        hang.setTargetPosition(hang.getCurrentPosition()-unlatchTicks);
        hang.setPower(1);
    }

    public void latch(){
        hang.setTargetPosition(hang.getCurrentPosition()+latchTicks);
        hang.setPower(1);
    }

    public void prepare(){
        //Add position for prep at end of auto
        hang.setTargetPosition(hang.getCurrentPosition()+prepareTicks);
        hang.setPower(1);
    }
}
