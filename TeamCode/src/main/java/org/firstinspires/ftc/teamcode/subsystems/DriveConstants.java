package org.firstinspires.ftc.teamcode.subsystems;

public class DriveConstants {
    public static final double TICKS_PER_REV = 1425.2;
    public static final double GEAR_RATIO = 1;
    public static final double WHEEL_DIAMETER = 2;
    public static final double INCHES_PER_TICK = WHEEL_DIAMETER * Math.PI * GEAR_RATIO / TICKS_PER_REV;

    public static final double TRACK_WIDTH = 18;

    public static double inchesToTicks(double inches){
        return inches/INCHES_PER_TICK;
    }

    public static double ticksToTinches(double ticks){
        return ticks*INCHES_PER_TICK;
    }
}
