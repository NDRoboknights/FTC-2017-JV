package org.firstinspires.ftc.utils;

/**
 * Created by sambl on 12/1/2017.
 */

    /**
     * Used for checking when a loop should continue running.
     * Used to generalize the loops.
     */
    public abstract class StatusChecker
    {
        /**
         * @return if a loop should continue running
         */
        public abstract boolean checkStatus();
    }
