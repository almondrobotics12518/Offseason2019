package org.firstinspires.ftc.teamcode.betterI2C;

/*
  code taken from Acme robotics github issue.
 */

import com.qualcomm.robotcore.hardware.I2cDeviceSynchImplOnSimple;
import com.qualcomm.robotcore.hardware.I2cDeviceSynchSimple;

public class BetterI2cDeviceSynchImplOnSimple extends I2cDeviceSynchImplOnSimple {
    public BetterI2cDeviceSynchImplOnSimple(I2cDeviceSynchSimple simple, boolean isSimpleOwned) {
        super(simple, isSimpleOwned);
    }

    @Override
    public void setReadWindow(ReadWindow window) {

    }
}