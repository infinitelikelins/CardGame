package com.bearya.robot.fairystory.walk.load.station;

public class StationRedLoad extends StationLoad {

    public static final int START_OID = 52500;
    public static final String NAME = "red";

    public StationRedLoad() {
        super(START_OID);
    }

    @Override
    public String getName() {
        return NAME;
    }

}