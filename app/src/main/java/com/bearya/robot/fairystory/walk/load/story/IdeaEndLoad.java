package com.bearya.robot.fairystory.walk.load.story;

import com.bearya.robot.base.play.Director;
import com.bearya.robot.base.play.FaceType;
import com.bearya.robot.base.play.LoadPlay;
import com.bearya.robot.fairystory.walk.load.EndLoad;

public class IdeaEndLoad extends EndLoad {

    public static final int START_OID = 1000;// 启动点码 (先于跳跳镇的终点码值重合)
    public static final String NAME = "兰科世界";  // 来源于 动画 虚幻勇士中的 计算机创造出来的虚拟世界

    public IdeaEndLoad() {
        super(START_OID);
    }

    @Override
    public void registerPlay() {
        Director.getInstance().register(ON_NEW_LOAD, new LoadPlay());
        Director.getInstance().register(ON_END_LOAD_SUCCESS, new LoadPlay());
        Director.getInstance().register(ON_END_LOAD_FAIL, new LoadPlay());
    }

    @Override
    public String[] getEquipmentLoads() {
        return new String[0];
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    protected String loadSuccessFacePlay() {
        return "";
    }

    @Override
    protected String loadFailFacePlay() {
        return "";
    }

    @Override
    protected int successGapTime() {
        return 0;
    }

    @Override
    protected FaceType defineType() {
        return null;
    }

    @Override
    protected String playSuccessSound() {
        return "";
    }

    @Override
    protected String playFailSound() {
        return "";
    }

    @Override
    protected int failGapTime() {
        return 0;
    }

}