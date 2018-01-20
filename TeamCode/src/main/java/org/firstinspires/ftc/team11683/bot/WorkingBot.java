package org.firstinspires.ftc.team11683.bot;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by sambl on 1/11/2018.
 */

public class WorkingBot extends Bot
{

    public DcMotor leftMotor;
    public DcMotor rightMotor;
    public DcMotor forkUp;

    public Servo leftClamp;
    public Servo rightClamp;
    public Servo cServo;

    public void init(HardwareMap hMap){
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
    }
}