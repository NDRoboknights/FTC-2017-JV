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
        //motors
        bot.rightMotor = hardwareMap.dcMotor.get("rightMotor");
        bot.rightMotor = hardwareMap.dcMotor.get("rightMotor");

        //sensor
        bot.colorSensor = hardwareMap.colorSensor.get("cSensor");
        //servo
        bot.leftClamp = hardwareMap.servo.get("leftClamp");
        bot.rightClamp = hardwareMap.servo.get("rightClamp");
        bot.cServo =  hardwareMap.servo.get("cServo");

        bot.init(hardwareMap);
        waitForStart();

        //init
        bot.rightClamp.setPosition(1);
        bot.leftClamp.setPosition(0.1);
        bot.rightClamp.setPosition(0.5);
        bot.leftClamp.setPosition(0.5);

        //could be 0.1 based on orientation
        while (opModeIsActive()){
            jewel.altknock("red");
        }
    }
}