package org.firstinspires.ftc.enums;

/**
 * Created by sambl on 11/16/2017.
 */
    public enum Direction
    {

        LEFT(-1), RIGHT(1);

        public int v;

        Direction(int v)
        {
            this.v = v;
        }
    }
