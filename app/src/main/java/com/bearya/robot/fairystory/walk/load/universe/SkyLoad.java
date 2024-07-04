package com.bearya.robot.fairystory.walk.load.universe;

import com.bearya.robot.fairystory.walk.load.XLoad;

public class SkyLoad extends XLoad {

    public static final int START_OID = 11800;//启动点码
    public static final String NAME = "空间地垫";

    public SkyLoad() {
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