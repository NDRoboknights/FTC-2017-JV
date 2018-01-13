package org.firstinspires.ftc.utils;

/**
 * Created by sambl on 12/1/2017.
 */


public class TimeChecker extends StatusChecker
{
    private long endTime;

    /**
     * @param time the time in milliseconds to complete the loop
     */
    public TimeChecker(long time)
    {
        this.endTime = System.currentTimeMillis() + time;
    }

    @Override
    public boolean checkStatus() {
        return System.currentTimeMillis() < endTime;
    }
}

