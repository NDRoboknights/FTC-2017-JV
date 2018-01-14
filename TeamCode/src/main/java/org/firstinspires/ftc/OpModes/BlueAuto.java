package org.firstinspires.ftc.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.AutoUtils.Jewel;
import org.firstinspires.ftc.utils.Status;

/**
 * Created by sambl on 9/26/2017.
 */
@Autonomous(name="BlueAuto", group="testGroup")
public class BlueAuto extends LinearOpMode
{
    public void runOpMode() throws InterruptedException
    {

        waitForStart();

        while (opModeIsActive())
        {
            telemetry.addData("OpMode Status: ", Status.BEGINNING);
            telemetry.update();
            Jewel jewel = new Jewel(telemetry, hardwareMap);
            telemetry.addData("interpreted color: ", jewel.interpretColor());
            telemetry.addData("OpMode Status: ", Status.WORKING);
            telemetry.update();
            jewel.altknock("blue");
            telemetry.addData("OpMode Status: ", Status.FINISHED);
            telemetry.update();
        }
    }
}