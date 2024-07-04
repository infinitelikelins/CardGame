package com.bearya.robot.fairystory.walk.load.story;

import com.bearya.robot.fairystory.ui.res.FileResource;
import com.bearya.robot.fairystory.ui.res.IntroduceTime;
import com.bearya.robot.fairystory.ui.res.MusicResource;
import com.bearya.robot.fairystory.walk.load.EquipmentLoad;

public class TreasureMapLoad extends EquipmentLoad {
    public static final int START_OID = 33600;//启动点码
    public static final String NAME = "藏宝图地垫";

    public TreasureMapLoad() {
        super(START_OID);
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    protected String loadFacePlay() {
        return FileResource.BASE_PATH + "story/equipment/picture/treasure";
    }

    @Override
    protected String playSound() {
        return MusicResource.BASE_PATH + "story/equipment/music/treasure_map.mp3";
    }

    @Override
    protected int loadFacePlayTime() {
        return IntroduceTime.treasurePlayTime;
    }

}