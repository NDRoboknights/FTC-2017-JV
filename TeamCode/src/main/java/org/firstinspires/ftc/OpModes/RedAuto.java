package org.firstinspires.ftc.OpModes;

//opmode
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

//PID
import org.firstinspires.ftc.AutoUtils.AutoExtender;
import org.firstinspires.ftc.AutoUtils.VuforiaScanner;
import org.firstinspires.ftc.Gyro.ADAFruitIMU;

//Others
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;

//java utils


/**
 * Created by sambl on 9/26/2017.
 */

@Autonomous(name="RedAuto", group="testGroup")
public class RedAuto extends LinearOpMode
{
    AutoExtender extender = new AutoExtender();

    public void runOpMode() throws InterruptedException
    {
        //motors
        extender.rMotor = hardwareMap.dcMotor.get("rMotor");
        extender.rMotor = hardwareMap.dcMotor.get("rMotor");

        //sensor
        extender.distSensor = hardwareMap.opticalDistanceSensor.get("ods");
        extender.colorSensor = hardwareMap.colorSensor.get("cSensor");
        //servo
        extender.leftClamp = hardwareMap.servo.get("leftClamp");
        extender.rightClamp = hardwareMap.servo.get("rightClamp");
        extender.CServo =  hardwareMap.servo.get("cServo");

        //etc
        extender.imu = new ADAFruitIMU(hardwareMap, "imu");
        RelicRecoveryVuMark vuMarkTrue;
        VuforiaScanner scanner = new VuforiaScanner();

        waitForStart();

        //init
        extender.rightClamp.setPosition(1);
        extender.leftClamp.setPosition(0.1);
        extender.rightClamp.setPosition(0.5);
        extender.leftClamp.setPosition(0.5);

        //could be 0.1 based on orientation
        extender.CServo.setPosition(0.9);
        while (opModeIsActive()){
            extender.Jewel.altknock("red");
            extender.CServo.setPosition(0.2);
//            extender.go.moveTo(15);
//            vuMarkTrue = extender.scanner.getVuMark();
//            while(vuMarkTrue == RelicRecoveryVuMark.UNKNOWN){
//                vuMarkTrue = extender.scanner.getVuMark();
//                if(System.nanoTime() > (3*(10^9))){
//                    break;
//                }
//            }
//            extender.rMotor.setPower(1);
//            extender.rMotor.setPower(1);
//            TimeUnit.SECONDS.sleep(1);
//            extender.rMotor.setPower(0);
//            extender.lMotor.setPower(0);

//            CryptoBox.redRun(extender.bot, vuMarkTrue);
        }
    }
}