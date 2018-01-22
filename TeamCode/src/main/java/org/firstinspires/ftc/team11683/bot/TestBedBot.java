package org.firstinspires.ftc.team11683.bot;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class TestBedBot extends Bot
{
    public DcMotor leftMotor;
    public DcMotor rightMotor;
    public Servo leftClamp;
    public Servo rightClamp;
    public Servo cServo;
    public DcMotor forkUp;
    public ColorSensor colorSensor;

    @Override
    public void init(HardwareMap hMap)
    {
        this.hardwareMap = hMap;
        leftMotor = hMap.dcMotor.get("leftMotor");
        rightMotor = hMap.dcMotor.get("rightMotor");
        leftMotor.setDirection(DcMotor.Direction.REVERSE);
        forkUp = hMap.dcMotor.get("forkupdn");

        leftClamp = hMap.servo.get("leftClamp");
        rightClamp = hMap.servo.get("rightClamp");
        cServo = hMap.servo.get("cServo");
        colorSensor = hMap.colorSensor.get("cSensor");

        leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        leftMotor.setPower(0);
        rightMotor.setPower(0);

        leftMotors.add(leftMotor);
        rightMotors.add(rightMotor);
    }
}
