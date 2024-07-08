package com.bearya.robot.fairystory.walk.load.station;

public class StationBlueLoad extends StationLoad {

    public static final int START_OID = 56100;
    public static final String NAME = "blue";

    public StationBlueLoad() {
        super(START_OID);
    }

    @Override
    public String getName() {
        return NAME;
    }

}