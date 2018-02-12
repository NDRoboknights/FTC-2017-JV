package org.firstinspires.ftc.team11683.AutoUtils;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.team11683.bot.AutoBot;
import org.firstinspires.ftc.team11683.enums.NewDirection;
import org.firstinspires.ftc.team11683.enums.Status;
import org.firstinspires.ftc.team11683.utils.Utilities;
import org.firstinspires.ftc.team11683.utils.CustomAutonomous;

/**
 * Created by sambl on 12/13/2017
 */

public class Jewel
{
    private Telemetry telemetry;
    private HardwareMap hardwareMap;
    public String AccColor;
    private  AutoBot bot = new AutoBot();
    public Status status;

    public Jewel(HardwareMap hMap, Telemetry telem)
    {
        this.hardwareMap = hMap;
        this.telemetry = telem;
        bot.init(hMap);
        
    }
    private  int getBlue(){return bot.colorSensor.blue();}
    private  int getRed(){return bot.colorSensor.red();}

    public  String interpretColor()
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

    public  void altknock(String team)
    {
        bot.cServo.setPosition(0.9);
        status = Status.BEGINNING;
        AccColor = interpretColor();

        telemetry.addData("color: ", AccColor);
        telemetry.addData("status: ", status);
        telemetry.update();

        if(AccColor.equals("blue") && team.equals("red"))
        {
            status = Status.WORKING;
            telemetry.addData("status: ", status);
            telemetry.update();
            bot.leftMotor.setPower(NewDirection.BACKWARD.v);
            bot.rightMotor.setPower(NewDirection.BACKWARD.v);
            Utilities.delay(400);
            bot.cServo.setPosition(0.2);
            Utilities.delay(600);
            bot.leftMotor.setPower(0);
            bot.rightMotor.setPower(0);
            status = Status.FINISHED;
            telemetry.addData("status: ", status);
            telemetry.update();
        }

        else if(AccColor.equals("blue") && team.equals("blue"))
        {
            status = Status.WORKING;
            telemetry.addData("status: ", status);
            telemetry.update();
            bot.leftMotor.setPower(NewDirection.FORWARD.v);
            bot.rightMotor.setPower(NewDirection.FORWARD.v);
            Utilities.delay(400);
            bot.cServo.setPosition(0.2);
            Utilities.delay(600);
            bot.rightMotor.setPower(0);
            bot.leftMotor.setPower(0);
            status = Status.FINISHED;
            telemetry.addData("status: ", status);
            telemetry.update();
        }
        if(AccColor.equals("red") && team.equals("blue"))
        {
            status = Status.WORKING;
            telemetry.addData("status: ", status);
            telemetry.update();
            bot.leftMotor.setPower(NewDirection.BACKWARD.v);
            bot.rightMotor.setPower(NewDirection.BACKWARD.v);
            Utilities.delay(400);
            bot.cServo.setPosition(0.2);
            Utilities.delay(600);
            bot.rightMotor.setPower(0);
            bot.leftMotor.setPower(0);
            status = Status.FINISHED;
            telemetry.addData("status: ", status);
            telemetry.update();
        }
        else if(AccColor.equals("red") && team.equals("red"))
        {
            status = Status.WORKING;
            telemetry.addData("status: ", status);
            telemetry.update();
            bot.leftMotor.setPower(NewDirection.FORWARD.v);
            bot.rightMotor.setPower(NewDirection.FORWARD.v);
            Utilities.delay(400);
            bot.cServo.setPosition(0.2);
            Utilities.delay(600);
            bot.rightMotor.setPower(0);
            bot.leftMotor.setPower(0);
            status = Status.FINISHED;
            telemetry.addData("status: ", status);
            telemetry.update();

        }
    }

}