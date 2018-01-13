package org.firstinspires.ftc.AutoUtils;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.bot.AutoBot;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import java.util.concurrent.TimeUnit;
import org.firstinspires.ftc.utils.CustomAutonomous;
/**
 * Created by sambl on 12/13/2017.
 */

public class Jewel {
    private Telemetry telemetry;
    private HardwareMap hardwareMap;
    private AutoBot bot = new AutoBot();
    private String AccColor = "";
    public Jewel(Telemetry telemetry, HardwareMap hardwareMap){
        this.telemetry = telemetry;
        this.hardwareMap = hardwareMap;
    }
    public int getBlue(){return bot.colorSensor.blue();}
    public int getRed(){return bot.colorSensor.red();}

    public String interpretColor(){
            if(getBlue() > CustomAutonomous.COLOR_THRESHOLD && getRed()<CustomAutonomous.COLOR_THRESHOLD)
            {
                AccColor = "blue";
                telemetry.addData("color:", AccColor);
                telemetry.update();
            }else if(getRed() > CustomAutonomous.COLOR_THRESHOLD && getBlue()<CustomAutonomous.COLOR_THRESHOLD)
            {
                AccColor = "red";
                telemetry.addData("color:", AccColor);
                telemetry.update();
            }else
            {
                AccColor = "unknown";
                telemetry.addData("color:", AccColor);
                telemetry.update();
            }
            return AccColor;
        }

    public void altknock(String team) throws InterruptedException {
        AccColor = interpretColor();
        if(AccColor.equals("blue") && team.equals("red")){
            bot.leftMotor.setPower(-1);
            bot.rightMotor.setPower(-1);
            telemetry.addData("C Servo Pos: ", bot.cServo.getPosition());
            telemetry.addData("L Motor Pos: ", bot.leftMotor.getPower());
            telemetry.addData("R Motor Pos: ", bot.rightMotor.getPower());
            telemetry.update();
            TimeUnit.SECONDS.wait(200);
            bot.cServo.setPosition(0.2);
            telemetry.addData("C Servo Pos: ", bot.cServo.getPosition());
            telemetry.addData("L Motor Pos: ", bot.leftMotor.getPower());
            telemetry.addData("R Motor Pos: ", bot.rightMotor.getPower());
            telemetry.update();
            TimeUnit.SECONDS.wait(600);
            bot.leftMotor.setPower(0);
            bot.rightMotor.setPower(0);
            telemetry.addData("C Servo Pos: ", bot.cServo.getPosition());
            telemetry.addData("L Motor Pos: ", bot.leftMotor.getPower());
            telemetry.addData("R Motor Pos: ", bot.rightMotor.getPower());
            telemetry.update();
        }else if(AccColor.equals("blue") && team.equals("blue")){
            bot.leftMotor.setPower(1);
            bot.rightMotor.setPower(1);
            telemetry.addData("C Servo Pos: ", bot.cServo.getPosition());
            telemetry.addData("L Motor Pos: ", bot.leftMotor.getPower());
            telemetry.addData("R Motor Pos: ", bot.rightMotor.getPower());
            telemetry.update();
            TimeUnit.SECONDS.wait(200);
            bot.cServo.setPosition(0.2);
            telemetry.addData("C Servo Pos: ", bot.cServo.getPosition());
            telemetry.addData("L Motor Pos: ", bot.leftMotor.getPower());
            telemetry.addData("R Motor Pos: ", bot.rightMotor.getPower());
            telemetry.update();
            TimeUnit.SECONDS.wait(600);
            bot.rightMotor.setPower(0);
            bot.leftMotor.setPower(0);
            telemetry.addData("C Servo Pos: ", bot.cServo.getPosition());
            telemetry.addData("L Motor Pos: ", bot.leftMotor.getPower());
            telemetry.addData("R Motor Pos: ", bot.rightMotor.getPower());
            telemetry.update();
        }
        if(AccColor.equals("red") && team.equals("blue")){
            bot.leftMotor.setPower(-1);
            bot.rightMotor.setPower(-1);
            telemetry.addData("C Servo Pos: ", bot.cServo.getPosition());
            telemetry.addData("L Motor Pos: ", bot.leftMotor.getPower());
            telemetry.addData("R Motor Pos: ", bot.rightMotor.getPower());
            telemetry.update();
            TimeUnit.SECONDS.wait(200);
            bot.cServo.setPosition(0.2);
            telemetry.addData("C Servo Pos: ", bot.cServo.getPosition());
            telemetry.addData("L Motor Pos: ", bot.leftMotor.getPower());
            telemetry.addData("R Motor Pos: ", bot.rightMotor.getPower());
            telemetry.update();
            TimeUnit.SECONDS.wait(600);
            bot.rightMotor.setPower(0);
            bot.leftMotor.setPower(0);
            telemetry.addData("C Servo Pos: ", bot.cServo.getPosition());
            telemetry.addData("L Motor Pos: ", bot.leftMotor.getPower());
            telemetry.addData("R Motor Pos: ", bot.rightMotor.getPower());
            telemetry.update();
        }else if(AccColor.equals("red") && team.equals("red")){
            bot.leftMotor.setPower(1);
            bot.rightMotor.setPower(1);
            telemetry.addData("C Servo Pos: ", bot.cServo.getPosition());
            telemetry.addData("L Motor Pos: ", bot.leftMotor.getPower());
            telemetry.addData("R Motor Pos: ", bot.rightMotor.getPower());
            telemetry.update();
            TimeUnit.SECONDS.wait(200);
            bot.cServo.setPosition(0.2);
            telemetry.addData("C Servo Pos: ", bot.cServo.getPosition());
            telemetry.addData("L Motor Pos: ", bot.leftMotor.getPower());
            telemetry.addData("R Motor Pos: ", bot.rightMotor.getPower());
            telemetry.update();
            TimeUnit.SECONDS.wait(600);
            bot.rightMotor.setPower(0);
            bot.leftMotor.setPower(0);
            telemetry.addData("C Servo Pos: ", bot.cServo.getPosition());
            telemetry.addData("L Motor Pos: ", bot.leftMotor.getPower());
            telemetry.addData("R Motor Pos: ", bot.rightMotor.getPower());
            telemetry.update();
        }
    }
}