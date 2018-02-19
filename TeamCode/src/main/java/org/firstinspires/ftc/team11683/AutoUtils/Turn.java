package org.firstinspires.ftc.team11683.AutoUtils;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.team11683.bot.WorkingBot;

/**
 * Created by sambl on 2/18/2018.
 */

public class Turn {
    WorkingBot bot=new WorkingBot();
    public Turn(WorkingBot bot){
        this.bot = bot;
    }
    public void resetencval(DcMotor l, DcMotor r){
        if(r.getCurrentPosition() >= 360) {
            r.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            r.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }
        if(l.getCurrentPosition() >= 360){
            l.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            l.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }
    }
    public void leftturn(int degrees){
        resetencval(bot.leftMotor, bot.rightMotor);
        bot.rightMotor.setTargetPosition(degrees);
        bot.rightMotor.setPower(1);
        bot.leftMotor.setTargetPosition(-degrees);
        bot.leftMotor.setPower(-1);
    }
    public void rightturn(int degrees){
        resetencval(bot.leftMotor, bot.rightMotor);
        bot.rightMotor.setTargetPosition(-degrees);
        bot.rightMotor.setPower(-1);
        bot.leftMotor.setTargetPosition(degrees);
        bot.leftMotor.setPower(1);
    }
}
