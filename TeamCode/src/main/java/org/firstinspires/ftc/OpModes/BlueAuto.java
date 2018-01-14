package org.firstinspires.ftc.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.AutoUtils.Jewel;

/**
 * Created by sambl on 9/26/2017.
 */
@Autonomous(name="BlueAuto", group="testGroup")
public class BlueAuto extends LinearOpMode
{

    public void runOpMode() throws InterruptedException
    {

        waitForStart();

        while (opModeIsActive()){
            Jewel jewel = new Jewel(telemetry, hardwareMap);
            jewel.altknock("blue");
        }
    }
}