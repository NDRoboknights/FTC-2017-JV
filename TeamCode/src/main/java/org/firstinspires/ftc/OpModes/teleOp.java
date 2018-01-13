//stuff that java did and i have no clue why
package org.firstinspires.ftc.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.Gyro.ADAFruitIMU;
import org.firstinspires.ftc.bot.TestBedBot;
import org.firstinspires.ftc.bot.WorkingBot;
import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Created by sambl on 9/25/2017
 */
@TeleOp(name = "TankTele", group = "teleOp")
public class teleOp extends CustomTeleOp
{
    public WorkingBot bot = new WorkingBot();

    //vars
    public long prevTime = 0;
    public int lPrevPos = 0;
    public int rPrevPos = 0;

    //init
    public void init()
    {
        bot.init(hardwareMap);
        //initialization
        bot.leftClamp.setPosition(1);
        bot.rightClamp.setPosition(0);
        bot.cServo.setPosition(0.2);

    }

    //loop
    public void loop()
    {
        long currTime = System.nanoTime();
        int lPos = bot.leftMotor.getCurrentPosition();
        int rPos = bot.rightMotor.getCurrentPosition();

        double dTime = (currTime - prevTime) * 10E-9;
        double dLPos = lPos - lPrevPos;
        double dRPos = rPos - rPrevPos;

        double lSpeed = Math.abs(dLPos/dTime);
        double rSpeed = Math.abs(dRPos/dTime);

        //joysticks
        double leftPower = gamepad1.left_stick_y;
        double rightPower = gamepad1.right_stick_y;

        //left
        if(Math.abs(leftPower) > JOYSTICK_THRESHOLD) {
            leftPower = scaleInput(leftPower);
            bot.leftMotor.setPower(leftPower);
        } else
            {
            bot.leftMotor.setPower(0);
        }

        //right
        if(Math.abs(rightPower) > JOYSTICK_THRESHOLD) {
            rightPower = scaleInput(rightPower);
            bot.rightMotor.setPower(rightPower);
        } else
            {
            bot.rightMotor.setPower(0);
        }

        //claw
        if (gamepad1.x)
        {
            bot.leftClamp.setPosition(0.4);
            bot.rightClamp.setPosition(0.4);
        }
        if (gamepad1.b)
        {
            bot.leftClamp.setPosition(1);
            bot.rightClamp.setPosition(0);
        }

        //forkUP
        if (gamepad1.dpad_up)
        {
            bot.forkUp.setPower(1);
        } else
            {
            bot.forkUp.setPower(0);
        }
        if (gamepad1.dpad_down)
        {
            bot.forkUp.setPower(-1);
        } else
            {
            bot.forkUp.setPower(0);
        }

        //telemetry
//        telemetry.addData("orientation: ", imu.getValue());
        telemetry.addData("L Position: ", lPos);
        telemetry.addData("R Position: ", rPos);
        telemetry.addData("L Speed: ", lSpeed);
        telemetry.addData("R Speed: ", rSpeed);
        telemetry.addData("LeftStickY: ", gamepad1.left_stick_y);
        telemetry.addData("RightStickY: ", gamepad1.right_stick_y);
        telemetry.addData("ForkUpP: ", bot.forkUp.getPower());
//        telemetry.addData("B: ", gamepad1.b);
//        telemetry.addData("X: ", gamepad1.x);
        telemetry.addData("RightClampPos: ", bot.rightClamp.getPosition());
        telemetry.addData("LeftClampPos: ", bot.leftClamp.getPosition());
        telemetry.update();

        //reset prev
        prevTime = currTime;
        lPrevPos = lPos;
        rPrevPos = rPos;
    }
}