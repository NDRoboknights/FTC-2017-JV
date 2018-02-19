package org.firstinspires.ftc.team11683.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.team11683.AutoUtils.Jewel;
import org.firstinspires.ftc.team11683.AutoUtils.Jewel2;

/**
 * Created by sambl on 9/26/2017.
 */
@Autonomous(name="newRedAuto", group="testGroup")
public class RedAuto extends LinearOpMode
{
    public void runOpMode() throws InterruptedException
    {
        waitForStart();

        Jewel2 jewel = new Jewel2(hardwareMap, telemetry);

        jewel.altknock("blue");
    }
}