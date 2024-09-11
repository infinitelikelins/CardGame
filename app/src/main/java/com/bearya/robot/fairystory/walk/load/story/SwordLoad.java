package com.bearya.robot.fairystory.walk.load.story;

import com.bearya.robot.base.play.FaceType;
import com.bearya.robot.fairystory.ui.res.FileResource;
import com.bearya.robot.fairystory.ui.res.IntroduceTime;
import com.bearya.robot.fairystory.ui.res.MusicResource;
import com.bearya.robot.fairystory.walk.load.EquipmentLoad;

public class SwordLoad extends EquipmentLoad {
    public static final int START_OID = 50700;//启动点码
    public static final String NAME = "宝剑地垫";

    public SwordLoad() {
        super(START_OID);
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    protected String loadFacePlay() {
        return FileResource.BASE_PATH + "story/equipment/picture/sword";
    }

    @Override
    protected String playSound() {
        return MusicResource.BASE_PATH + "story/equipment/music/hero_sword.mp3";
    }

    @Override
    protected int loadFacePlayTime() {
        return IntroduceTime.swordPlayTime;
    }

    protected FaceType defineType() {
        return FaceType.Frame;
    }

}