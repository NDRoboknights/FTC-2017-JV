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
    private static int target;
    public void blueRun(TestBedBot bot, RelicRecoveryVuMark vuMark) throws InterruptedException {
        //For blue, we go from left to right
        if(vuMark == RelicRecoveryVuMark.LEFT){
            target = BlueBox.LEFT.v;
        } else if(vuMark == RelicRecoveryVuMark.CENTER){
            target = BlueBox.CENTER.v;
        }else if(vuMark == RelicRecoveryVuMark.RIGHT){
            target = BlueBox.RIGHT.v;
        }else{
            target = BlueBox.CENTER.v;
        }
    }

    public static void redRun(TestBedBot bot, RelicRecoveryVuMark vuMark) throws InterruptedException {
        //For red, we go from right to left
        if(vuMark == RelicRecoveryVuMark.LEFT){
            target = RedBox.LEFT.v;
        } else if(vuMark == RelicRecoveryVuMark.CENTER){
            target = RedBox.CENTER.v;
        }else if(vuMark == RelicRecoveryVuMark.RIGHT){
            target = RedBox.RIGHT.v;
        }else{
            target = RedBox.CENTER.v;
        }
    }
}