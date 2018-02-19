package org.firstinspires.ftc.team11683.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.team11683.AutoUtils.Turn;
import org.firstinspires.ftc.team11683.bot.WorkingBot;

/**
 * Created by sambl on 2/18/2018.
 */
@TeleOp(name="turn")
public class turnTest extends OpMode
{
    WorkingBot bot=new WorkingBot();
    Turn turn;
    public void init(){
        turn = new Turn(bot);
    }
    public void loop(){
        if(gamepad1.a){
            turn.leftturn(90);
        }
        if(gamepad1.y){
            turn.rightturn(90);
        }
    }
}
