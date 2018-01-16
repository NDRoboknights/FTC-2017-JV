package org.firstinspires.ftc.AutoUtils;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.enums.Status;

import java.util.concurrent.TimeUnit;

/**
 * Created by sambl on 1/15/2018.
 */

public class VuforiaUse
{
    private Telemetry telemetry;
    private RelicRecoveryVuMark vuMark;
    public VuforiaScanner scanner = new VuforiaScanner();

    public VuforiaUse(Telemetry telem){
        this.telemetry = telem;
    }

    public RelicRecoveryVuMark fullRun()
    {
        telemetry.addData("Vuforia Status: ", Status.INITIALIZED);
        telemetry.update();
        vuMark = scanner.getVuMark();
        telemetry.addData("VuMark Seen: ", vuMark);
        telemetry.addData("Vuforia Status: ", Status.WORKING);
        telemetry.update();
        while(vuMark==RelicRecoveryVuMark.UNKNOWN && TimeUnit.SECONDS.toSeconds(System.nanoTime())<3) {
            vuMark = scanner.getVuMark();
        }
        telemetry.addData("Vuforia Status: ", Status.FINISHED);
        telemetry.addData("VuMark Seen: ", vuMark);
        telemetry.update();
        return vuMark;
    }
}
