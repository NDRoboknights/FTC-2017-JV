package org.firstinspires.ftc.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.AutoUtils.Jewel;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;

/**
 * Created by sambl on 9/26/2017.
 */
@Autonomous(name="RedAuto", group="testGroup")
public class RedAuto extends LinearOpMode
{
    public void runOpMode() throws InterruptedException
    {
        RelicRecoveryVuMark vuMark;

        waitForStart();
        Jewel jewel = new Jewel(telemetry, hardwareMap);

        while (opModeIsActive()){

            telemetry.addData("interpreted color: ", jewel.interpretColor());
            telemetry.update();
            jewel.altknock("red");
        }
    }
}