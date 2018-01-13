package org.firstinspires.ftc.OpModes;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.AutoUtils.AutoExtender;
import org.firstinspires.ftc.utils.CustomAutonomous;

/**
 * Created by sambl on 11/20/2017.
 */
@TeleOp(name="sensor", group = "Test")
public class SensorVal extends OpMode
{
    AutoExtender extender = new AutoExtender();
    String AccColor;
    private double getDist() {return extender.distSensor.getLightDetected();}

    private double getRDist() {return extender.distSensor.getRawLightDetected();}

    private int getBlue() {return extender.colorSensor.blue();}

    private int getRed() {return extender.colorSensor.red();}

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
    private double getDegrees(){return extender.imu.getValue();}

    public void init()
    {
        extender.colorSensor = hardwareMap.colorSensor.get("cSensor");
        extender.distSensor = hardwareMap.opticalDistanceSensor.get("ods");
        extender.distSensor.enableLed(true);
        extender.colorSensor.enableLed(true);
    }
    public void loop()
    {
        telemetry.addData("Degrees: ", getDegrees());
        telemetry.addData("Blue: ", getBlue());
        telemetry.addData("Red: ", getRed());
        telemetry.addData("interpreted color: ", interpretColor());
        telemetry.addData("ODS Status: ", extender.distSensor.status());
        telemetry.addData("ODS Norm: ", getDist());
        telemetry.addData("ODS Raw: ", getRDist());
        telemetry.update();
    }
}
