package org.firstinspires.ftc.AutoUtils;

/**
 * Created by sambl on 12/1/2017.
 */


import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.bot.TestBedBot;
import org.firstinspires.ftc.enums.cryptobox.BlueBox;
import org.firstinspires.ftc.enums.cryptobox.RedBox;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;


public class CryptoBox
{
    HardwareMap hardwareMap;
    private static TestBedBot Tbot = new TestBedBot();
    public CryptoBox(HardwareMap hMap){
        this.hardwareMap = hMap;
        Tbot.init(hMap);
    }
    private static int setBlueTarget(RelicRecoveryVuMark vuMark)
    {
        //For blue, we go from left to right
        int target;
        if(vuMark == RelicRecoveryVuMark.LEFT)
        {
            target = BlueBox.LEFT.v;
        } else if(vuMark == RelicRecoveryVuMark.CENTER)
        {
            target = BlueBox.CENTER.v;
        }else if(vuMark == RelicRecoveryVuMark.RIGHT)
        {
            target = BlueBox.RIGHT.v;
        }else
            {
            target = BlueBox.CENTER.v;
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
        } else if(vuMark == RelicRecoveryVuMark.CENTER)
        {
            target = RedBox.CENTER.v;
        }else if(vuMark == RelicRecoveryVuMark.RIGHT)
        {
            target = RedBox.RIGHT.v;
        }else
            {
            target = RedBox.CENTER.v;
        }
        return target;
    }
    public static void blueRun(TestBedBot bot, RelicRecoveryVuMark vuMark)
    {
        setBlueTarget(vuMark);
    }

    public void redRun(TestBedBot bot, RelicRecoveryVuMark vuMark)
    {
        setRedTarget(vuMark);
    }
}