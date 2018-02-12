package org.firstinspires.ftc.team11683.telemetry;

import org.firstinspires.ftc.team11683.AutoUtils.Jewel;
import org.firstinspires.ftc.team11683.enums.Color;
import org.firstinspires.ftc.team11683.enums.Status;

/**
 * Created by sambl on 2/11/2018.
 */

public class jewelTelem extends Jewel
{
    public Jewel jewel;

    private int jewelstat = jewel.status;

    public Status jewelStatus(int jewelstat)
    {
        Status stat = Status.BEGINNING;
        if(jewelstat == 0){
            stat = Status.BEGINNING;
        }else if(jewelstat ==1 ) {
            stat = Status.INITIALIZED;
        }else if(jewelstat == 2){
            stat = Status.WORKING;
        }else if(jewelstat == 3){
            stat = Status.FINISHED;
        }
        return stat;
    }

    public Color colorDetrected(String color)
    {
        Color jewelColor;

        if(color.equals("red")){
            jewelColor = Color.RED;
        }else{
            jewelColor = Color.BLUE;
        }

        return jewelColor;
    }
}
