package org.firstinspires.ftc.teamcode.subsystems;

import com.disnodeteam.dogecv.CameraViewDisplay;
import com.disnodeteam.dogecv.DogeCV;
import com.disnodeteam.dogecv.detectors.roverrukus.GoldDetector;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.opencv.core.Point;

import static org.firstinspires.ftc.teamcode.subsystems.Detector.MineralPosition.RIGHT;

public class Detector {

    public GoldDetector detector;

    public Detector(HardwareMap hardwareMap){
        detector = new GoldDetector(); // Create detector
        detector.init(hardwareMap.appContext, CameraViewDisplay.getInstance(), DogeCV.CameraMode.FRONT,false); // Initialize it with the app context and camera
        detector.useDefaults(); // Set detector to use default settings

        detector.cropTLCorner = new Point(200, 200); //Sets the top left corner of the new image, in pixel (x,y) coordinates
        detector.cropBRCorner = new Point(400, 400);

        // Optional tuning
        detector.downscale = 1; // How much to downscale the input frames

        detector.areaScoringMethod = DogeCV.AreaScoringMethod.MAX_AREA; // Can also be PERFECT_AREA
        //detector.perfectAreaScorer.perfectArea = 10000; // if using PERFECT_AREA scoring
        detector.maxAreaScorer.weight = 0.005; //

        detector.ratioScorer.weight = 5; //
        detector.ratioScorer.perfectRatio = 1.0; // Ratio adjustment
    }

    public void enable(){
        detector.enable();
    }

    public void disable(){
        detector.disable();
    }

    public void setCrop(Point TLCorner, Point BRCorner){
        detector.cropBRCorner = TLCorner;
        detector.cropTLCorner = BRCorner;
    }

    public boolean isDetected(int width, int height){

        if(width < detector.getFoundRect().width && height < detector.getFoundRect().height){
            return true;
        } else {
            return false;
        }

    }

    public MineralPosition getMineralPosition(){
        return RIGHT;
    }

    public enum MineralPosition {
        LEFT,RIGHT,MIDDLE
    }
}
