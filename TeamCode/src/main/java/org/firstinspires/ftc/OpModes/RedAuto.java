package org.firstinspires.ftc.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.AutoUtils.Jewel;

/**
 * Created by sambl on 9/26/2017.
 */
@Autonomous(name="RedAuto", group="testGroup")
public class RedAuto extends LinearOpMode
{
    public void runOpMode() throws InterruptedException
    {

        waitForStart();

        while (opModeIsActive()){
            Jewel jewel = new Jewel(telemetry, hardwareMap);
            telemetry.addData("interpreted color: ", jewel.interpretColor());

            jewel.altknock("red");
        }
    }
}