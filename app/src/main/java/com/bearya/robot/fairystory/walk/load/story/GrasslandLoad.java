package com.bearya.robot.fairystory.walk.load.story;

import com.bearya.robot.fairystory.walk.load.XLoad;

public class GrasslandLoad extends XLoad {

    public static final int START_OID = 11800;//启动点码
    public static final String NAME = "草地地垫";

    public GrasslandLoad() {
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
