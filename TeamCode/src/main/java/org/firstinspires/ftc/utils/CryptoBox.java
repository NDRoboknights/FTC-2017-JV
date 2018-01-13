package org.firstinspires.ftc.utils;

/**
 * Created by sambl on 12/1/2017.
 */
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.PID.PIDController;
import org.firstinspires.ftc.PID.PIDFunctions;
import org.firstinspires.ftc.bot.TestBedBot;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.PID.PIDFunctions.PIDStraightThread;
import org.firstinspires.ftc.bot.Bot;

import static org.firstinspires.ftc.utils.Utilities.scalePower;

public class CryptoBox
{
    PIDController pidController;
    TestBedBot bot;
    public void turn(Direction dir, double angle, CycleChecker sChecker)
    {
        pidController.setTarget(angle);
        pidController.start();
        while(sChecker.checkStatus())
        {
            double lPower = dir.v * Math.abs(pidController.getOutput());
            double rPower = -dir.v * Math.abs(pidController.getOutput());

            double[] powers = scalePower(lPower, rPower);
            bot.setDrivePower(powers[0], powers[1]);
        }
        bot.setDrivePower(0,0);
        pidController.stop();
    }
    public void blueRun(Bot bot, RelicRecoveryVuMark vuMark) throws InterruptedException {
        //For blue, we go from left to right

        //find target count
        int target;
        if(vuMark.equals(RelicRecoveryVuMark.RIGHT)) {
            target = 3;
        }
        else if(vuMark.equals(RelicRecoveryVuMark.CENTER)) {
            target = 2;
        }
        else if(vuMark.equals(RelicRecoveryVuMark.LEFT)){
            target = 1;
        }else{
            target = (int) Math.random() * 3+1;
        }

        PIDStraightThread sThread = new PIDFunctions.PIDStraightThread(bot.pidFunctions, 0);
        sThread.thread.start();

        int count = 0;

        TimeChecker tChecker = new TimeChecker(2500);
        boolean prevColor = false;
        while(count < target && tChecker.checkStatus())
        {
            if(!prevColor && bot.cSensor1.blue() >= CustomAutonomous.COLOR_THRESHOLD) {
                count++;
                prevColor = true;
            }
            else if(prevColor && bot.cSensor1.blue() < CustomAutonomous.COLOR_THRESHOLD) {
                prevColor = false;
            }
        }
        //replace with servos
//        StatusChecker cChecker = new StatusChecker();
//        turn(Direction.LEFT, 90, cChecker);
//        sThread.setRunning(false);
//        sThread.thread.join();
//
//
//        Utilities.delay(1500);

    }

    public static void redRun(Bot bot, RelicRecoveryVuMark vuMark) throws InterruptedException {
        //For red, we go from right to left

        //find target count
        int target;
        if(vuMark.equals(RelicRecoveryVuMark.LEFT)) {
            target = 4;
        }
        else if(vuMark.equals(RelicRecoveryVuMark.CENTER)) {
            target = 3;
        }
        else {
            target = 2;
        }

        PIDFunctions.PIDStraightThread sThread = new PIDFunctions.PIDStraightThread(bot.pidFunctions, 0);
        sThread.thread.start();


        int count = 0;

        TimeChecker tChecker = new TimeChecker(2500);
        boolean prevColor = false;
        while(count < target && tChecker.checkStatus())
        {
            if(!prevColor && bot.cSensor1.blue() >= CustomAutonomous.COLOR_THRESHOLD) {
                count++;
                prevColor = true;
            }
            else if(prevColor && bot.cSensor1.blue() < CustomAutonomous.COLOR_THRESHOLD) {
                prevColor = false;
            }
        }
        //replace with servos
//        bot.middleMotor.setPower(0);
//        sThread.setRunning(false);
//        sThread.thread.join();
//
//        delay(1500);
    }
}