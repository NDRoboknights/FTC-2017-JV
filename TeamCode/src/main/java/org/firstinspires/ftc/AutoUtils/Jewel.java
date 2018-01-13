package org.firstinspires.ftc.AutoUtils;
import org.firstinspires.ftc.bot.AutoBot;
import org.firstinspires.ftc.robotcore.external.Telemetry;

import java.util.concurrent.TimeUnit;
import org.firstinspires.ftc.utils.CustomAutonomous;
/**
 * Created by sambl on 12/13/2017.
 */

public class Jewel {
    private Telemetry telemetry;
    private AutoBot extender;
    private String AccColor = "";
    public Jewel(Telemetry telemetry){
        this.telemetry = telemetry;
    }
    public int getBlue(){return extender.colorSensor.blue();}
    public int getRed(){return extender.colorSensor.red();}

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
            extender.lMotor.setPower(-1);
            extender.rMotor.setPower(-1);
            telemetry.addData("C Servo Pos: ", extender.CServo.getPosition());
            telemetry.addData("L Motor Pos: ", extender.lMotor.getPower());
            telemetry.addData("R Motor Pos: ", extender.rMotor.getPower());
            telemetry.update();
            TimeUnit.SECONDS.wait(200);
            extender.CServo.setPosition(0.2);
            telemetry.addData("C Servo Pos: ", extender.CServo.getPosition());
            telemetry.addData("L Motor Pos: ", extender.lMotor.getPower());
            telemetry.addData("R Motor Pos: ", extender.rMotor.getPower());
            telemetry.update();
            TimeUnit.SECONDS.wait(600);
            extender.lMotor.setPower(0);
            extender.rMotor.setPower(0);
            telemetry.addData("C Servo Pos: ", extender.CServo.getPosition());
            telemetry.addData("L Motor Pos: ", extender.lMotor.getPower());
            telemetry.addData("R Motor Pos: ", extender.rMotor.getPower());
            telemetry.update();
        }else if(AccColor.equals("blue") && team.equals("blue")){
            extender.lMotor.setPower(1);
            extender.rMotor.setPower(1);
            telemetry.addData("C Servo Pos: ", extender.CServo.getPosition());
            telemetry.addData("L Motor Pos: ", extender.lMotor.getPower());
            telemetry.addData("R Motor Pos: ", extender.rMotor.getPower());
            telemetry.update();
            TimeUnit.SECONDS.wait(200);
            extender.CServo.setPosition(0.2);
            telemetry.addData("C Servo Pos: ", extender.CServo.getPosition());
            telemetry.addData("L Motor Pos: ", extender.lMotor.getPower());
            telemetry.addData("R Motor Pos: ", extender.rMotor.getPower());
            telemetry.update();
            TimeUnit.SECONDS.wait(600);
            extender.rMotor.setPower(0);
            extender.lMotor.setPower(0);
            telemetry.addData("C Servo Pos: ", extender.CServo.getPosition());
            telemetry.addData("L Motor Pos: ", extender.lMotor.getPower());
            telemetry.addData("R Motor Pos: ", extender.rMotor.getPower());
            telemetry.update();
        }
        if(AccColor.equals("red") && team.equals("blue")){
            extender.lMotor.setPower(-1);
            extender.rMotor.setPower(-1);
            telemetry.addData("C Servo Pos: ", extender.CServo.getPosition());
            telemetry.addData("L Motor Pos: ", extender.lMotor.getPower());
            telemetry.addData("R Motor Pos: ", extender.rMotor.getPower());
            telemetry.update();
            TimeUnit.SECONDS.wait(200);
            extender.CServo.setPosition(0.2);
            telemetry.addData("C Servo Pos: ", extender.CServo.getPosition());
            telemetry.addData("L Motor Pos: ", extender.lMotor.getPower());
            telemetry.addData("R Motor Pos: ", extender.rMotor.getPower());
            telemetry.update();
            TimeUnit.SECONDS.wait(600);
            extender.rMotor.setPower(0);
            extender.lMotor.setPower(0);
            telemetry.addData("C Servo Pos: ", extender.CServo.getPosition());
            telemetry.addData("L Motor Pos: ", extender.lMotor.getPower());
            telemetry.addData("R Motor Pos: ", extender.rMotor.getPower());
            telemetry.update();
        }else if(AccColor.equals("red") && team.equals("red")){
            extender.lMotor.setPower(1);
            extender.rMotor.setPower(1);
            telemetry.addData("C Servo Pos: ", extender.CServo.getPosition());
            telemetry.addData("L Motor Pos: ", extender.lMotor.getPower());
            telemetry.addData("R Motor Pos: ", extender.rMotor.getPower());
            telemetry.update();
            TimeUnit.SECONDS.wait(200);
            extender.CServo.setPosition(0.2);
            telemetry.addData("C Servo Pos: ", extender.CServo.getPosition());
            telemetry.addData("L Motor Pos: ", extender.lMotor.getPower());
            telemetry.addData("R Motor Pos: ", extender.rMotor.getPower());
            telemetry.update();
            TimeUnit.SECONDS.wait(600);
            extender.rMotor.setPower(0);
            extender.lMotor.setPower(0);
            telemetry.addData("C Servo Pos: ", extender.CServo.getPosition());
            telemetry.addData("L Motor Pos: ", extender.lMotor.getPower());
            telemetry.addData("R Motor Pos: ", extender.rMotor.getPower());
            telemetry.update();
        }
    }
}