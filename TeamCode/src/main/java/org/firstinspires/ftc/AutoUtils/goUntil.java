package org.firstinspires.ftc.AutoUtils;

import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.bot.AutoBot;

/**
 * Created by sambl on 12/13/2017.
 */

public class goUntil
{
    AutoBot bot = new AutoBot();
    public void moveTo(int distincm)
    {
        //motors
        bot.rightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        double distance = bot.distSensor.getLightDetected();
        double rawDist = bot.distSensor.getRawLightDetected();
        double dist = (distance + rawDist) / 2;
        while (dist > distincm)
        {
            distance = bot.distSensor.getLightDetected();
            rawDist = bot.distSensor.getRawLightDetected();
            dist = (distance + rawDist) / 2;
            bot.leftMotor.setPower(-1);
            bot.rightMotor.setPower(1);
            if (dist <= distincm)
            {
                bot.leftMotor.setPower(0);
                bot.rightMotor.setPower(0);
                break;
            }
        }
    }
}