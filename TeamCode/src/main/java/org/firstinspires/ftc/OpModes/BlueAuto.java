package org.firstinspires.ftc.OpModes;

//opmode
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

//others
import org.firstinspires.ftc.AutoUtils.Jewel;
import org.firstinspires.ftc.bot.AutoBot;
import org.firstinspires.ftc.Gyro.ADAFruitIMU;


/**
 * Created by sambl on 9/26/2017.
 */
@Autonomous(name="BlueAuto", group="testGroup")
public class BlueAuto extends LinearOpMode
{
    AutoBot bot = new AutoBot();
    Jewel jewel = new Jewel(telemetry, hardwareMap);
    public void runOpMode() throws InterruptedException
    {
        //motors
        bot.rightMotor = hardwareMap.dcMotor.get("rightMotor");
        bot.leftMotor = hardwareMap.dcMotor.get("leftMotor");

        //sensors
        bot.colorSensor = hardwareMap.colorSensor.get("cSensor");
        
        //servos
        bot.leftClamp = hardwareMap.servo.get("leftClamp");
        bot.rightClamp = hardwareMap.servo.get("rightClamp");
        bot.cServo =  hardwareMap.servo.get("cServo");

        //bot.imu
        bot.imu = new ADAFruitIMU(hardwareMap, "imu");

        waitForStart();

        //init
        bot.rightClamp.setPosition(0.1);
        bot.leftClamp.setPosition(1);

        bot.rightClamp.setPosition(0.5);
        bot.leftClamp.setPosition(0.5);
        while (opModeIsActive()){
            jewel.altknock("blue");

//            bot.go.moveTo(10);
//            bot.vuMarkTrue = bot.getVuMark.getMark();
//            while(bot.vuMarkTrue == null){
//                bot.vuMarkTrue = bot.getVuMark.getMark();
//            }
//            bot.leftMotor.setPower(1);
//            bot.rightMotor.setPower(1);
//            TimeUnit.SECONDS.sleep(1);
//              bot.leftMotor.setPower(0);
//              bot.rightMotor.setPower(0);
//            CryptoBox.redRun(bot.bot,bot.vuMarkTrue);
        }
    }
}