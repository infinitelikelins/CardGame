package com.bearya.robot.fairystory.walk.load.story;

import com.bearya.robot.base.play.FaceType;
import com.bearya.robot.fairystory.ui.res.FileResource;
import com.bearya.robot.fairystory.ui.res.IntroduceTime;
import com.bearya.robot.fairystory.ui.res.MusicResource;
import com.bearya.robot.fairystory.walk.load.EquipmentLoad;

public class ArmorLoad extends EquipmentLoad {

    public static final int START_OID = 49800;//启动点码
    public static final String NAME = "铠甲地垫";

    public ArmorLoad() {
        super(START_OID);
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    protected String loadFacePlay() {
        return FileResource.BASE_PATH + "story/equipment/picture/armor";
    }

    @Override
    protected String playSound() {
        return MusicResource.BASE_PATH + "story/equipment/music/hero_armor.mp3";
    }

    @Override
    protected int loadFacePlayTime() {
        return IntroduceTime.armorPlayTime;
    }

    protected FaceType defineType() {
        return FaceType.Frame;
    }

}
