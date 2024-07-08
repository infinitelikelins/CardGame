package com.bearya.robot.fairystory.walk.load.station;

public class StationPinkLoad extends StationLoad {

    public static final int START_OID = 51600;
    public static final String NAME = "pink";

    public StationPinkLoad() {
        super(START_OID);
    }

    @Override
    public String getName() {
        return NAME;
    }

}