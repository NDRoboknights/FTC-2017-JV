package org.firstinspires.ftc.team11683.AutoUtils;

/**
 * Created by sambl on 12/1/2017.
 */


import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.team11683.bot.TestBedBot;
import org.firstinspires.ftc.team11683.enums.Status;
import org.firstinspires.ftc.team11683.enums.cryptobox.BlueBox;
import org.firstinspires.ftc.team11683.enums.cryptobox.RedBox;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;


public class CryptoBox
{
    private HardwareMap hardwareMap;
    private static Telemetry telemetry;
    private static TestBedBot bot = new TestBedBot();
    public CryptoBox(Telemetry telem, HardwareMap hMap){
        this.hardwareMap = hMap;
        this.telemetry = telem;
        bot.init(hMap);
    }
    private static int setBlueTarget(RelicRecoveryVuMark vuMark)
    {
        //For blue, we go from left to right
        int target;
        if(vuMark == RelicRecoveryVuMark.LEFT)
        {
            target = BlueBox.LEFT.v;
            telemetry.addLine("Cryptobox Status: " + Status.BEGINNING);
            telemetry.addLine("Column: " + BlueBox.LEFT);
            telemetry.addLine("vuMark: " + vuMark);
            telemetry.update();
        } else if(vuMark == RelicRecoveryVuMark.CENTER)
        {
            target = BlueBox.CENTER.v;
            telemetry.addLine("Cryptobox Status: " + Status.BEGINNING);
            telemetry.addLine("Column: " + BlueBox.CENTER);
            telemetry.addLine("vuMark: " + vuMark);
            telemetry.update();
        }else if(vuMark == RelicRecoveryVuMark.RIGHT)
        {
            target = BlueBox.RIGHT.v;
            telemetry.addLine("Cryptobox Status: " + Status.BEGINNING);
            telemetry.addLine("Column: " + BlueBox.RIGHT);
            telemetry.addLine("vuMark: " + vuMark);
            telemetry.update();
        }else
            {
            target = BlueBox.CENTER.v;
            telemetry.addLine("Cryptobox Status: " + Status.BEGINNING);
            telemetry.addLine("Column: " + BlueBox.CENTER);
            telemetry.addLine("vuMark: " + vuMark);
            telemetry.update();
        }
        return target;
    }
    private static int setRedTarget(RelicRecoveryVuMark vuMark)
    {
        //For red, we go from right to left
        int target;

        if(vuMark == RelicRecoveryVuMark.LEFT)
        {
            target = RedBox.LEFT.v;
            telemetry.addLine("Cryptobox Status: " + Status.BEGINNING);
            telemetry.addLine("Column: " + RedBox.LEFT);
            telemetry.addLine("vuMark: " + vuMark);
            telemetry.update();
        } else if(vuMark == RelicRecoveryVuMark.CENTER)
        {
            target = RedBox.CENTER.v;
            telemetry.addLine("Cryptobox Status: " + Status.BEGINNING);
            telemetry.addLine("Column: " + RedBox.CENTER);
            telemetry.addLine("vuMark: " + vuMark);
            telemetry.update();
        }else if(vuMark == RelicRecoveryVuMark.RIGHT)
        {
            target = RedBox.RIGHT.v;
            telemetry.addLine("Cryptobox Status: " + Status.BEGINNING);
            telemetry.addLine("Column: " + RedBox.RIGHT);
            telemetry.addLine("vuMark: " + vuMark);
            telemetry.update();
        }else
            {
            target = RedBox.CENTER.v;
            telemetry.addLine("Cryptobox Status: " + Status.BEGINNING);
            telemetry.addLine("Column: " + RedBox.CENTER);
            telemetry.addLine("vuMark: " + vuMark);
            telemetry.update();
        }
        return target;
    }
    public static void blueRun(RelicRecoveryVuMark vuMark)
    {
        setBlueTarget(vuMark);
    }

    public static void redRun(RelicRecoveryVuMark vuMark)
    {
        setRedTarget(vuMark);
    }
}