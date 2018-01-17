package org.firstinspires.ftc.AutoUtils;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.bot.ColorBot;
import org.firstinspires.ftc.enums.NewDirection;
import org.firstinspires.ftc.enums.Status;
import org.firstinspires.ftc.utils.Utilities;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.utils.CustomAutonomous;
/**
 * Created by sambl on 12/13/2017
 */

public class Jewel
{
    private Telemetry telemetry;
    private HardwareMap hardwareMap;
    private String AccColor;
<<<<<<< HEAD
    private DcMotor RMotor;
    private DcMotor LMotor;
    private ColorSensor colorSensor;
    private StatusChecker sChecker;
=======
    private ColorBot bot = new ColorBot();
>>>>>>> master

    public Jewel(Telemetry telemetry, HardwareMap hMap)
    {
        this.telemetry = telemetry;
        this.hardwareMap = hMap;
        bot.init(hardwareMap);
        
    }

<<<<<<< HEAD
    private int getBlue(){return colorSensor.blue();}
    private int getRed(){return colorSensor.red();}
=======
    private int getBlue(){return bot.colorSensor.blue();}
    private int getRed(){return bot.colorSensor.red();}
>>>>>>> master

    public String interpretColor(){
            if(getBlue() > CustomAutonomous.COLOR_THRESHOLD && getRed()<CustomAutonomous.COLOR_THRESHOLD)
            {
                AccColor = "blue";
                telemetry.addData("color:", AccColor);
                
            }else if(getRed() > CustomAutonomous.COLOR_THRESHOLD && getBlue()<CustomAutonomous.COLOR_THRESHOLD)
            {
                AccColor = "red";
                telemetry.addData("color:", AccColor);
                
            }else
            {
                AccColor = "unknown";
                telemetry.addData("color:", AccColor);
                
            }
            return AccColor;
        }

    public void altknock(String team)
    {
        telemetry.addData("Jewel Status", Status.BEGINNING);
        telemetry.update();
        AccColor = interpretColor();
        telemetry.addData("Color: ", AccColor);
        telemetry.update();

<<<<<<< HEAD
        if(AccColor.equals("blue") && team.equals("red")){
            telemetry.addData("Jewel Status", Status.WORKING);
=======
        if(AccColor.equals("blue") && team.equals("red"))
        {
            telemetry.addData("Status: ", Status.WORKING);
>>>>>>> master
            telemetry.update();
            bot.LMotor.setPower(NewDirection.BACKWARD.v);
            bot.RMotor.setPower(NewDirection.BACKWARD.v);
            Utilities.delay(400);
            bot.cServo.setPosition(0.2);
            Utilities.delay(600);
<<<<<<< HEAD
            LMotor.setPower(0);
            RMotor.setPower(0);
            telemetry.addData("Jewel Status", Status.FINISHED);
            telemetry.update();

        }else if(AccColor.equals("blue") && team.equals("blue")){
            telemetry.addData("Jewel Status", Status.WORKING);
=======
            bot.LMotor.setPower(0);
            bot.RMotor.setPower(0);
            telemetry.addData("Status: ", Status.FINISHED);
            telemetry.update();

        }
        else if(AccColor.equals("blue") && team.equals("blue"))
        {
            telemetry.addData("Status: ", Status.WORKING);
>>>>>>> master
            telemetry.update();
            bot.LMotor.setPower(NewDirection.FORWARD.v);
            bot.RMotor.setPower(NewDirection.FORWARD.v);
            Utilities.delay(400);
            bot.cServo.setPosition(0.2);
            Utilities.delay(600);
<<<<<<< HEAD
            RMotor.setPower(0);
            LMotor.setPower(0);
            telemetry.addData("Jewel Status", Status.FINISHED);
            telemetry.update();
        }
        if(AccColor.equals("red") && team.equals("blue")){
            telemetry.addData("Jewel Status", Status.WORKING);
=======
            bot.RMotor.setPower(0);
            bot.LMotor.setPower(0);
            telemetry.addData("Status: ", Status.FINISHED);
            telemetry.update();
        }
        if(AccColor.equals("red") && team.equals("blue"))
        {
            telemetry.addData("Status: ", Status.WORKING);
>>>>>>> master
            telemetry.update();
            bot.LMotor.setPower(NewDirection.BACKWARD.v);
            bot.RMotor.setPower(NewDirection.BACKWARD.v);
            Utilities.delay(400);
            bot.cServo.setPosition(0.2);
            Utilities.delay(600);
<<<<<<< HEAD
            RMotor.setPower(0);
            LMotor.setPower(0);
            telemetry.addData("Jewel Status", Status.FINISHED);
            telemetry.update();
        }else if(AccColor.equals("red") && team.equals("red")){
            telemetry.addData("Jewel Status", Status.WORKING);
=======
            bot.RMotor.setPower(0);
            bot.LMotor.setPower(0);
            telemetry.addData("Status: ", Status.FINISHED);
            telemetry.update();
        }
        else if(AccColor.equals("red") && team.equals("red"))
        {
            telemetry.addData("Status: ", Status.WORKING);
>>>>>>> master
            telemetry.update();
            bot.LMotor.setPower(NewDirection.FORWARD.v);
            bot.RMotor.setPower(NewDirection.FORWARD.v);
            Utilities.delay(400);
            bot.cServo.setPosition(0.2);
            Utilities.delay(600);
<<<<<<< HEAD
            RMotor.setPower(0);
            LMotor.setPower(0);
            telemetry.addData("Jewel Status", Status.FINISHED);
=======
            bot.RMotor.setPower(0);
            bot.LMotor.setPower(0);
            telemetry.addData("Status: ", Status.FINISHED);
>>>>>>> master
            telemetry.update();
        }
    }
}