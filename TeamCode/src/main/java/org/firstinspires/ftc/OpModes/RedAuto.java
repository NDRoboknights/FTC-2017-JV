package org.firstinspires.ftc.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.bot.AutoBot;


/**
 * Created by sambl on 9/26/2017.
 */

@Autonomous(name="RedAuto", group="testGroup")
public class RedAuto extends LinearOpMode
{
    AutoBot bot = new AutoBot();

    public void runOpMode() throws InterruptedException
    {
        //motors
        bot.rMotor = hardwareMap.dcMotor.get("rMotor");
        bot.rMotor = hardwareMap.dcMotor.get("rMotor");

        //sensor
//        bot.distSensor = hardwareMap.opticalDistanceSensor.get("ods");
        bot.colorSensor = hardwareMap.colorSensor.get("cSensor");
        //servo
        bot.leftClamp = hardwareMap.servo.get("leftClamp");
        bot.rightClamp = hardwareMap.servo.get("rightClamp");
        bot.CServo =  hardwareMap.servo.get("cServo");
        
        waitForStart();

        //init
        bot.rightClamp.setPosition(1);
        bot.leftClamp.setPosition(0.1);
        bot.rightClamp.setPosition(0.5);
        bot.leftClamp.setPosition(0.5);

        //could be 0.1 based on orientation
        while (opModeIsActive()){
            bot.Jewel.altknock("red");
        }
    }
}