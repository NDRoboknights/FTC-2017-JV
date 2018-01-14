package org.firstinspires.ftc.AutoUtils;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.bot.AutoBot;
import org.firstinspires.ftc.utils.StatusChecker;
import org.firstinspires.ftc.utils.Utilities;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.utils.CustomAutonomous;
/**
 * Created by sambl on 12/13/2017.
 */

public class Jewel
{
    private Telemetry telemetry;
    private HardwareMap hardwareMap;
    private AutoBot bot = new AutoBot();
    private String AccColor;
    private DcMotor RMotor;
    private DcMotor LMotor;
    private ColorSensor colorSensor;
    private StatusChecker sChecker;
    public Jewel(Telemetry telemetry, HardwareMap hMap)
    {
        this.telemetry = telemetry;
        this.hardwareMap = hMap;
        colorSensor = hMap.colorSensor.get("cSensor");
        LMotor = hMap.dcMotor.get("leftMotor");
        RMotor = hMap.dcMotor.get("rightMotor");
    }

    public int getBlue(){return colorSensor.blue();}
    public int getRed(){return colorSensor.red();}

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

    public void altknock(String team) throws InterruptedException {
        AccColor = interpretColor();
        if(AccColor.equals("blue") && team.equals("red")){
            LMotor.setPower(-1);
            RMotor.setPower(-1);
            Utilities.delay(1000);
            bot.cServo.setPosition(0.2);
            LMotor.setPower(0);
            RMotor.setPower(0);
            
        }else if(AccColor.equals("blue") && team.equals("blue")){
            LMotor.setPower(1);
            RMotor.setPower(1);
            Utilities.delay(1000);
            bot.cServo.setPosition(0.2);
            RMotor.setPower(0);
            LMotor.setPower(0);
            
        }
        if(AccColor.equals("red") && team.equals("blue")){
            LMotor.setPower(-1);
            RMotor.setPower(-1);
            Utilities.delay(1000);
            bot.cServo.setPosition(0.2);
            RMotor.setPower(0);
            LMotor.setPower(0);

            
        }else if(AccColor.equals("red") && team.equals("red")){
            LMotor.setPower(1);
            RMotor.setPower(1);
            Utilities.delay(1000);
            bot.cServo.setPosition(0.2);
            RMotor.setPower(0);
            LMotor.setPower(0);
            
        }
    }
}