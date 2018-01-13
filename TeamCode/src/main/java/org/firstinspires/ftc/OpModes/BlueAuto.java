package org.firstinspires.ftc.OpModes;

//opmode
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

//others
import org.firstinspires.ftc.AutoUtils.Jewel;
import org.firstinspires.ftc.bot.AutoBot;


/**
 * Created by sambl on 9/26/2017.
 */
@Autonomous(name="BlueAuto", group="testGroup")
public class BlueAuto extends LinearOpMode
{
    AutoBot bot = new AutoBot();
    Jewel jewel = new Jewel(telemetry, hardwareMap);

    public void runOpMode() throws InterruptedException
    {
        bot.init(hardwareMap);

        waitForStart();

        while (opModeIsActive()){
            jewel.altknock("blue");
        }
    }
}