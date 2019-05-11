package org.firstinspires.ftc.teamcode.math;

public class Pose {
    public double x;
    public double y;
    public double theta;

    public Pose(double x, double y, double theta){
        this.x = x;
        this.y = y;
        this.theta = theta;
    }

    public void setPose(double x, double y, double theta){
        this.x = x;
        this.y = y;
        this.theta = theta;
    }

}
