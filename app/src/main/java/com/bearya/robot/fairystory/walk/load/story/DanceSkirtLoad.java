package com.bearya.robot.fairystory.walk.load.story;

import com.bearya.robot.fairystory.ui.res.FileResource;
import com.bearya.robot.fairystory.ui.res.IntroduceTime;
import com.bearya.robot.fairystory.ui.res.MusicResource;
import com.bearya.robot.fairystory.walk.load.EquipmentLoad;

public class DanceSkirtLoad extends EquipmentLoad {
    public static final int START_OID = 46200;//启动点码
    public static final String NAME = "舞裙地垫";

    public DanceSkirtLoad() {
        super(START_OID);
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    protected String loadFacePlay() {
        return FileResource.BASE_PATH + "story/equipment/picture/skirt";
    }

    @Override
    protected String playSound() {
        return MusicResource.BASE_PATH + "story/equipment/music/ball_skirt.mp3";
    }

    @Override
    protected int loadFacePlayTime() {
        return IntroduceTime.danceSkirtPlayTime;
    }

}