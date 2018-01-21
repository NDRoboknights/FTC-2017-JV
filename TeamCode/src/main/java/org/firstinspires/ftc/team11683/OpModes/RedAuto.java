package org.firstinspires.ftc.team11683.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.team11683.AutoUtils.CryptoBox;
import org.firstinspires.ftc.team11683.AutoUtils.Jewel;
import org.firstinspires.ftc.team11683.AutoUtils.VuforiaScanner;
import org.firstinspires.ftc.team11683.bot.TestBedBot;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;

import java.util.concurrent.TimeUnit;

/**
 * Created by sambl on 9/26/2017.
 */
@Autonomous(name="newRedAuto", group="testGroup")
public class RedAuto extends LinearOpMode
{
    public void runOpMode() throws InterruptedException
    {
        long time = System.nanoTime();
        RelicRecoveryVuMark vuMark = RelicRecoveryVuMark.UNKNOWN;

        waitForStart();

        VuforiaScanner scanner = new VuforiaScanner();
        Jewel jewel = new Jewel(telemetry, hardwareMap);
        CryptoBox box = new CryptoBox(telemetry, hardwareMap);
        TestBedBot bot = new TestBedBot();

//        scanner.initialize();

        while (opModeIsActive())
        {
//            while(vuMark == RelicRecoveryVuMark.UNKNOWN && TimeUnit.SECONDS.toSeconds(time)<3)
//            {
//                vuMark = scanner.getVuMark();
//                time = System.nanoTime();
//            }

            jewel.altknock("red");

//            box.redRun(vuMark);

        }
    }
}