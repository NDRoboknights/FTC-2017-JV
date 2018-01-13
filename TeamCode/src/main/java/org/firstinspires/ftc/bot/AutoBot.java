package org.firstinspires.ftc.bot;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
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

public class AutoBot
{
    private TestBedBot bot = new TestBedBot();
    //motors
    public DcMotor rMotor;
    public DcMotor lMotor;

    //sensors
    public OpticalDistanceSensor distSensor;
    public ColorSensor colorSensor;

    //servo
    public Servo leftClamp;
    public Servo rightClamp;
    public Servo CServo;

    //vuforia
    public VuforiaScanner scanner;

    //gyro
    public ADAFruitIMU imu;

    //vars
    public RelicRecoveryVuMark vuMarkTrue;

    //pid
    private PIDController pidController = new PIDController(imu, bot.pidc);
    public PIDFunctions func = new PIDFunctions(bot, pidController);


    private Telemetry telemetry = null;
}