package org.firstinspires.ftc.teamcode.math;

public class PoseMath {
    public static double distanceFormula(Pose start, Pose end){
        return Math.sqrt(Math.pow(end.x-start.x,2)+Math.pow(end.y-start.y,2));
    }
}
