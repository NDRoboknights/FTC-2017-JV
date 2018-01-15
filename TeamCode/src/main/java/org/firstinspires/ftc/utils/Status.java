package org.firstinspires.ftc.utils;

/**
 * Created by sambl on 1/13/2018.
 */

public enum Status {

    INITIALIZED(1), BEGINNING(0), WORKING(2), FINISHED(3);

    public int v;
    Status(int v){
        this.v = v;
    }
}
