package org.firstinspires.ftc.bot;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.AutoUtils.Jewel;
import org.firstinspires.ftc.AutoUtils.VuforiaScanner;
import org.firstinspires.ftc.AutoUtils.goUntil;
import org.firstinspires.ftc.Gyro.ADAFruitIMU;
import org.firstinspires.ftc.PID.PIDController;
import org.firstinspires.ftc.PID.PIDFunctions;
import org.firstinspires.ftc.bot.TestBedBot;
import org.firstinspires.ftc.bot.WorkingBot;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.utils.StatusChecker;

/**
 * Created by sambl on 12/19/2017.
 */

public class AutoBot extends Bot
{
    private TestBedBot bot = new TestBedBot();
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

    //vuforia
    public VuforiaScanner scanner;

    //gyro
    public ADAFruitIMU imu;

    //vars
    public RelicRecoveryVuMark vuMarkTrue;

    //pid
    private PIDController pidController = new PIDController(imu, bot.pidc);
    public PIDFunctions func = new PIDFunctions(bot, pidController);
    public void init(HardwareMap hMap){
        this.hardwareMap = hMap;

        leftMotor = hMap.dcMotor.get("lMotor");
        rightMotor = hMap.dcMotor.get("rMotor");
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