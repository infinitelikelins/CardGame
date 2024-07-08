package com.bearya.robot.fairystory.walk.load.station;

public class StationPurpleLoad extends StationLoad {

    public static final int START_OID = 55200;
    public static final String NAME = "purple";

    public StationPurpleLoad() {
        super(START_OID);
    }

    @Override
    public String getName() {
        return NAME;
    }

}