package org.firstinspires.ftc.AutoUtils;

import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.bot.AutoBot;

/**
 * Created by sambl on 12/13/2017.
 */

public class goUntil
{
    AutoBot bot;
    public void moveTo(int distincm)
    {
        //motors
        bot.rMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        double distance = bot.distSensor.getLightDetected();
        double rawDist = bot.distSensor.getRawLightDetected();
        double dist = (distance + rawDist) / 2;
        while (dist > distincm)
        {
            distance = bot.distSensor.getLightDetected();
            rawDist = bot.distSensor.getRawLightDetected();
            dist = (distance + rawDist) / 2;
            bot.lMotor.setPower(-1);
            bot.rMotor.setPower(1);
            if (dist <= distincm)
            {
                bot.lMotor.setPower(0);
                bot.rMotor.setPower(0);
                break;
            }
        }
    }
}