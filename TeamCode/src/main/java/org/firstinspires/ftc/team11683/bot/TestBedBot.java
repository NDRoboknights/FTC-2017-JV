package org.firstinspires.ftc.team11683.bot;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDCoefficients;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.team11683.Gyro.ADAFruitIMU;
import org.firstinspires.ftc.team11683.PID.PIDController;
import org.firstinspires.ftc.team11683.PID.PIDFunctions;
import org.firstinspires.ftc.team11683.PID.PIDInput;


public class TestBedBot extends Bot
{
    public DcMotor leftMotor;
    public DcMotor rightMotor;
    public Servo leftClamp;
    public Servo rightClamp;
    public Servo cServo;
    public DcMotor forkUp;
    public ADAFruitIMU imu;
    public PIDCoefficients pidc;
    public PIDFunctions pidFunctions;
    public PIDController pidController;
    public PIDInput pidInput;
    public ColorSensor colorSensor;
    @Override
    public void init(HardwareMap hMap)
    {
        pidc = new PIDCoefficients();
        pidController = new PIDController(pidInput, pidc);
        pidFunctions = new PIDFunctions(this, pidController);
        this.hardwareMap = hMap;
        leftMotor = hMap.dcMotor.get("lMotor");
        rightMotor = hMap.dcMotor.get("rMotor");
        leftMotor.setDirection(DcMotor.Direction.REVERSE);
        forkUp = hMap.dcMotor.get("forkupdn");

        leftClamp = hMap.servo.get("leftClamp");
        rightClamp = hMap.servo.get("rightClamp");
        cServo = hMap.servo.get("cServo");
        imu = new ADAFruitIMU(hMap, "imu");
        colorSensor = hMap.colorSensor.get("cSensor");

        leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        leftMotor.setPower(0);
        rightMotor.setPower(0);

        leftMotors.add(leftMotor);
        rightMotors.add(rightMotor);
    }
}
