package com.bearya.robot.fairystory.walk.load.story;

import com.bearya.robot.fairystory.ui.res.FileResource;
import com.bearya.robot.fairystory.ui.res.IntroduceTime;
import com.bearya.robot.fairystory.ui.res.MusicResource;
import com.bearya.robot.fairystory.walk.load.EquipmentLoad;

public class CrystalShoesLoad extends EquipmentLoad {
    public static final int START_OID = 47100;//启动点码
    public static final String NAME = "水晶鞋地垫";

    public CrystalShoesLoad() {
        super(START_OID);
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    protected String loadFacePlay() {
        return FileResource.BASE_PATH + "story/equipment/picture/shoes";
    }

    @Override
    protected String playSound() {
        return MusicResource.BASE_PATH + "story/equipment/music/ball_shoes.mp3";
    }

    @Override
    protected int loadFacePlayTime() {
        return IntroduceTime.crystalShoesPlayTime;
    }

}
