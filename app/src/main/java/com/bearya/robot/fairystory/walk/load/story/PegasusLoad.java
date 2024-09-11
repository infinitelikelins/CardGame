package com.bearya.robot.fairystory.walk.load.story;

import com.bearya.robot.base.play.FaceType;
import com.bearya.robot.fairystory.ui.res.FileResource;
import com.bearya.robot.fairystory.ui.res.IntroduceTime;
import com.bearya.robot.fairystory.ui.res.MusicResource;
import com.bearya.robot.fairystory.walk.load.EquipmentLoad;

public class PegasusLoad extends EquipmentLoad {
    public static final int START_OID = 48900;//启动点码
    public static final String NAME = "飞马地垫";

    public PegasusLoad() {
        super(START_OID);
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    protected String loadFacePlay() {
        return FileResource.BASE_PATH + "story/equipment/picture/pegasus";
    }

    @Override
    protected String playSound() {
        return MusicResource.BASE_PATH + "story/equipment/music/hero_horse.mp3";
    }

    @Override
    protected int loadFacePlayTime() {
        return IntroduceTime.pegasusPlayTime;
    }

    protected FaceType defineType() {
        return FaceType.Frame;
    }

}