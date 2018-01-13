package org.firstinspires.ftc.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.AutoUtils.Jewel;
import org.firstinspires.ftc.bot.AutoBot;


/**
 * Created by sambl on 9/26/2017.
 */

@Autonomous(name="RedAuto", group="testGroup")
public class RedAuto extends LinearOpMode
{
    AutoBot bot = new AutoBot();
    Jewel jewel = new Jewel(telemetry, hardwareMap);

    public void runOpMode() throws InterruptedException
    {

        bot.init(hardwareMap);

        waitForStart();

        //could be 0.1 based on orientation
        while (opModeIsActive()){
            jewel.altknock("red");
        }
    }
}