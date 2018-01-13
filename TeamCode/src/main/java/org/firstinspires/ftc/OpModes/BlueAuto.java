package org.firstinspires.ftc.OpModes;

//opmode
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

//others
import org.firstinspires.ftc.bot.AutoBot;
import org.firstinspires.ftc.Gyro.ADAFruitIMU;


/**
 * Created by sambl on 9/26/2017.
 */
@Autonomous(name="BlueAuto", group="testGroup")
public class BlueAuto extends LinearOpMode
{
    AutoBot extender = new AutoBot();

    public void runOpMode() throws InterruptedException
    {
        //motors
        extender.rMotor = hardwareMap.dcMotor.get("rMotor");
        extender.lMotor = hardwareMap.dcMotor.get("lMotor");

        //sensors
        extender.distSensor = hardwareMap.opticalDistanceSensor.get("ods");
        extender.colorSensor = hardwareMap.colorSensor.get("cSensor");
        //servos
        extender.leftClamp = hardwareMap.servo.get("leftClamp");
        extender.rightClamp = hardwareMap.servo.get("rightClamp");
        extender.CServo =  hardwareMap.servo.get("cServo");

        //extender.imu
        extender.imu = new ADAFruitIMU(hardwareMap, "imu");

        waitForStart();

        //init
        extender.rightClamp.setPosition(0.1);
        extender.leftClamp.setPosition(1);

        extender.rightClamp.setPosition(0.5);
        extender.leftClamp.setPosition(0.5);
        while (opModeIsActive()){
            extender.Jewel.altknock("blue");

//            extender.go.moveTo(10);
//            extender.vuMarkTrue = extender.getVuMark.getMark();
//            while(extender.vuMarkTrue == null){
//                extender.vuMarkTrue = extender.getVuMark.getMark();
//            }
//            extender.lMotor.setPower(1);
//            extender.rMotor.setPower(1);
//            TimeUnit.SECONDS.sleep(1);
//              extender.lMotor.setPower(0);
//              extender.rMotor.setPower(0);
//            CryptoBox.redRun(extender.bot,extender.vuMarkTrue);
        }
    }
}