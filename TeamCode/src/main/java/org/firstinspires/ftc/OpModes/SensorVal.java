package org.firstinspires.ftc.OpModes;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.bot.AutoBot;
import org.firstinspires.ftc.utils.CustomAutonomous;

/**
 * Created by sambl on 11/20/2017.
 */
@TeleOp(name="sensor", group = "Test")
public class SensorVal extends OpMode
{
    AutoBot bot = new AutoBot();
    String AccColor;
    private double getDist() {return bot.distSensor.getLightDetected();}

    private double getRDist() {return bot.distSensor.getRawLightDetected();}

    private int getBlue() {return bot.colorSensor.blue();}

    private int getRed() {return bot.colorSensor.red();}

    private String interpretColor()
    {
        if(getBlue() > CustomAutonomous.COLOR_THRESHOLD && getRed()<CustomAutonomous.COLOR_THRESHOLD)
        {
            AccColor = "blue";
        }else if(getRed() > CustomAutonomous.COLOR_THRESHOLD && getBlue()<CustomAutonomous.COLOR_THRESHOLD)
            {
            AccColor = "red";
        }else
            {
            AccColor = "unknown";
        }
        return AccColor;
    }

    public void init()
    {
        bot.colorSensor = hardwareMap.colorSensor.get("cSensor");
        bot.distSensor = hardwareMap.opticalDistanceSensor.get("ods");
        bot.distSensor.enableLed(true);
        bot.colorSensor.enableLed(true);
    }

    public void loop()
    {
        telemetry.addData("Blue: ", getBlue());
        telemetry.addData("Red: ", getRed());
        telemetry.addData("interpreted color: ", interpretColor());
        telemetry.addData("ODS Status: ", bot.distSensor.status());
        telemetry.addData("ODS Norm: ", getDist());
        telemetry.addData("ODS Raw: ", getRDist());
        telemetry.update();
    }
}
