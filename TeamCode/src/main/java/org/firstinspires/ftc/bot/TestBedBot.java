package org.firstinspires.ftc.bot;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDCoefficients;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.Gyro.ADAFruitIMU;
import org.firstinspires.ftc.PID.PIDController;
import org.firstinspires.ftc.PID.PIDInput;


public class TestBedBot extends Bot
{
    public DcMotor leftMotor;
    public DcMotor rightMotor;
    public Servo leftClamp;
    public Servo rightClamp;
    public Servo cServo;
    public DcMotor forkUp;
    public ADAFruitIMU imu;
    PIDInput pidInput;
    public PIDCoefficients pidc;
    @Override
    public void init(HardwareMap hMap)
    {
        pidc = new PIDCoefficients();
        this.hardwareMap = hMap;
        leftMotor = hMap.dcMotor.get("lMotor");
        rightMotor = hMap.dcMotor.get("rMotor");
        leftMotor.setDirection(DcMotor.Direction.REVERSE);
        forkUp = hMap.dcMotor.get("forkupdn");

        leftClamp = hMap.servo.get("leftClamp");
        rightClamp = hMap.servo.get("rightClamp");
        cServo = hMap.servo.get("cServo");
        imu = new ADAFruitIMU(hMap, "imu");

        leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        leftMotor.setPower(0);
        rightMotor.setPower(0);

        leftMotors.add(leftMotor);
        rightMotors.add(rightMotor);
    }
}
