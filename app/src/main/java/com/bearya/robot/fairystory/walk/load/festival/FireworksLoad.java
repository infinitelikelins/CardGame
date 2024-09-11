package com.bearya.robot.fairystory.walk.load.festival;

import com.bearya.robot.fairystory.walk.load.XLoad;

public class FireworksLoad extends XLoad {

    public static final int START_OID = 11800;//启动点码
    public static final String NAME = "烟花地垫";

    public FireworksLoad() {
        super(START_OID);
    }

    @Override
    public void registerPlay() {

    }

    @Override
    public String getName() {
        return NAME;
    }

}
