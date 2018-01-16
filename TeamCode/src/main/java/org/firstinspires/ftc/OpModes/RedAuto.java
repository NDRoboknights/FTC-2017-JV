package org.firstinspires.ftc.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.AutoUtils.Jewel;
import org.firstinspires.ftc.AutoUtils.VuforiaUse;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;

/**
 * Created by sambl on 9/26/2017.
 */
@Autonomous(name="RedAuto", group="testGroup")
public class RedAuto extends LinearOpMode
{
    public void runOpMode() throws InterruptedException
    {
        RelicRecoveryVuMark vuMark;

        waitForStart();

        Jewel jewel = new Jewel(telemetry, hardwareMap);
        VuforiaUse vuf = new VuforiaUse(telemetry);

        vuf.scanner.initialize();

        while (opModeIsActive()){
            vuMark = vuf.fullRun();
            telemetry.addData("interpreted color: ", jewel.interpretColor());
            telemetry.addData("VuMark Seen: ", vuMark);
            telemetry.update();
            jewel.altknock("red");
        }
    }
}