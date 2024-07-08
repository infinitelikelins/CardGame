package com.bearya.robot.fairystory.walk.load.station;

public class StationYellowLoad extends StationLoad {

    public static final int START_OID = 53400;
    public static final String NAME = "yellow";

    public StationYellowLoad() {
        super(START_OID);
    }

    @Override
    public String getName() {
        return NAME;
    }

}