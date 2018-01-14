package org.firstinspires.ftc.bot;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;


/**
 * Created by sambl on 12/19/2017.
 */
public class AutoBot extends Bot
{
    //motors
    public DcMotor rightMotor;
    public DcMotor leftMotor;
    public DcMotor forkUp;

    //sensors
    public OpticalDistanceSensor distSensor;
    public ColorSensor colorSensor;

    //servo
    public Servo leftClamp;
    public Servo rightClamp;
    public Servo cServo;


    public void init(HardwareMap hMap)
    {
        this.hardwareMap = hMap;

        leftMotor = hMap.dcMotor.get("leftMotor");
        rightMotor = hMap.dcMotor.get("rightMotor");
        leftMotor.setDirection(DcMotor.Direction.REVERSE);

        forkUp = hMap.dcMotor.get("forkupdn");

        leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        leftClamp = hMap.servo.get("leftClamp");
        rightClamp = hMap.servo.get("rightClamp");
        cServo = hMap.servo.get("cServo");

        colorSensor = hMap.colorSensor.get("cSensor");
    }
}
