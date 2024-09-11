package com.bearya.robot.fairystory.walk.load.story;

import com.bearya.robot.base.play.FaceType;
import com.bearya.robot.fairystory.ui.res.FileResource;
import com.bearya.robot.fairystory.ui.res.IntroduceTime;
import com.bearya.robot.fairystory.ui.res.MusicResource;
import com.bearya.robot.fairystory.walk.load.EquipmentLoad;

public class CompassLoad extends EquipmentLoad {

    public static final int START_OID = 34500;//启动点码

    public static final String NAME = "指南针地垫";

    public CompassLoad() {
        super(START_OID);
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    protected String loadFacePlay() {
        return FileResource.BASE_PATH + "story/equipment/picture/compass";
    }

    @Override
    protected String playSound() {
        return MusicResource.BASE_PATH + "story/equipment/music/treasure_compass.mp3";
    }

    @Override
    protected int loadFacePlayTime() {
        return IntroduceTime.compassPlayTime;
    }

    protected FaceType defineType() {
        return FaceType.Frame;
    }

}
