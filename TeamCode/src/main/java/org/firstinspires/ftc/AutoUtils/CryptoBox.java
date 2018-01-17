package org.firstinspires.ftc.AutoUtils;

/**
 * Created by sambl on 12/1/2017.
 */


import org.firstinspires.ftc.bot.TestBedBot;
import org.firstinspires.ftc.enums.cryptobox.BlueBox;
import org.firstinspires.ftc.enums.cryptobox.RedBox;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;


public class CryptoBox
{
    TestBedBot bot = new TestBedBot();
    private int setBlueTarget(RelicRecoveryVuMark vuMark)
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
    private int setRedTarget(RelicRecoveryVuMark vuMark)
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
    public void blueRun(TestBedBot bot, RelicRecoveryVuMark vuMark)
    {
        setBlueTarget(vuMark);
    }

    public void redRun(TestBedBot bot, RelicRecoveryVuMark vuMark)
    {
        setRedTarget(vuMark);
    }
}