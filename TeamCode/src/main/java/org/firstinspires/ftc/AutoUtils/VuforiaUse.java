package org.firstinspires.ftc.AutoUtils;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.utils.Status;

/**
 * Created by sambl on 1/15/2018.
 */

public class VuforiaUse {
    private Telemetry telemetry;
    private RelicRecoveryVuMark vuMark;
    public VuforiaUse(Telemetry telem){
        this.telemetry = telem;
    }
    private VuforiaScanner scanner = new VuforiaScanner();
    public RelicRecoveryVuMark fullRun(){
        telemetry.addData("Vuforia Status: ", Status.BEGINNING);
        telemetry.update();
        scanner.initialize();
        telemetry.addData("Vuforia Status: ", Status.INITIALIZED);
        telemetry.update();
        vuMark = scanner.getVuMark();
        telemetry.addData("VuMark Seen: ", vuMark);
        telemetry.addData("Vuforia Status: ", Status.WORKING);
        telemetry.update();
        while(vuMark==RelicRecoveryVuMark.UNKNOWN) {
            vuMark = scanner.getVuMark();
        }
        telemetry.addData("Vuforia Status: ", Status.FINISHED);
        telemetry.addData("VuMark Seen: ", vuMark);
        telemetry.update();
        return vuMark;
    }
}
