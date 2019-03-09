package org.firstinspires.ftc.teamcode.logging;

public class OdometryThread extends Thread {
    /*
     * This boolean is used to determine if the thread should continue to run.
     */

    public boolean isRunning;

    /*
     * These are variables that represent the robot's position and angle.
     * Theta is the robot's angle.
     */

    public double currentX;
    public double currentY;
    public double theta;

    public OdometryThread(){
        
    }

    public void run() {

    }

    public void setIsRunning(boolean isRunning){
        this.isRunning = isRunning;
    }


}
