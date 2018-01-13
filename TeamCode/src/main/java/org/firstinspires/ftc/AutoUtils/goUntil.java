package org.firstinspires.ftc.AutoUtils;

import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.OpModes.RedAuto;

/**
 * Created by sambl on 12/13/2017.
 */

public class goUntil
{
    AutoExtender myAutoExtender;
    public void moveTo(int distincm)
    {
        //motors
        myAutoExtender.rMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        double distance = myAutoExtender.distSensor.getLightDetected();
        double rawDist = myAutoExtender.distSensor.getRawLightDetected();
        double dist = (distance + rawDist) / 2;
        while (dist > distincm)
        {
            distance = myAutoExtender.distSensor.getLightDetected();
            rawDist = myAutoExtender.distSensor.getRawLightDetected();
            dist = (distance + rawDist) / 2;
            myAutoExtender.lMotor.setPower(-1);
            myAutoExtender.rMotor.setPower(1);
            if (dist <= distincm)
            {
                myAutoExtender.lMotor.setPower(0);
                myAutoExtender.rMotor.setPower(0);
                break;
            }
        }
    }
}