package com.bearya.robot.base.play;

public class TimeAction {
    private long time;
    private int action;

    public TimeAction(int action, long time) {
        this.time = time;
        this.action = action;
    }

    public long getTime() {
        return time;
    }

    public int getAction() {
        return action;
    }
}
