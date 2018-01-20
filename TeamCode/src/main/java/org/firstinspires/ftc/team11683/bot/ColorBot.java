package org.firstinspires.ftc.team11683.bot;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by sambl on 1/15/2018.
 */

public class ColorBot extends Bot{
    public DcMotor LMotor;
    public DcMotor RMotor;
    public ColorSensor colorSensor;
    public Servo cServo;

    public void init(HardwareMap hardwareMap)
    {
        this.hardwareMap = hardwareMap;
        cServo = hardwareMap.servo.get("cServo");
        colorSensor = hardwareMap.colorSensor.get("cSensor");
        LMotor = hardwareMap.dcMotor.get("leftMotor");
        RMotor = hardwareMap.dcMotor.get("rightMotor");
    }
}
