package org.firstinspires.ftc.enums;

/**
 * Created by sambl on 1/13/2018.
 */

public enum NewDirection
{

    FORWARD(1), BACKWARD(-1);

    public int v;

    NewDirection(int v){
        this.v = v;
    }
}

