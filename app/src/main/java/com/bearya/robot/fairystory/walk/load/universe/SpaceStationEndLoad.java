package com.bearya.robot.fairystory.walk.load.universe;

import com.bearya.robot.base.play.FaceType;
import com.bearya.robot.fairystory.ui.res.MusicResource;
import com.bearya.robot.fairystory.ui.res.PictureResource;
import com.bearya.robot.fairystory.walk.load.EndLoad;

public class SpaceStationEndLoad extends EndLoad {

    public static final int START_OID = 57900;//启动点码

    public static final String NAME = "有趣的空间站";

    public SpaceStationEndLoad() {
        super(START_OID);
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String[] getEquipmentLoads() {
        return new String[]{
                SpaceStationRoleLoad.NAME, // 空间站的作用
                SpaceStationBuildLoad.NAME, // 空间站的建造
                SpaceStationCompositionLoad.NAME // 空间站的组成
        };
    }

    @Override
    protected FaceType defineType() {
        return FaceType.Image;
    }

    @Override
    protected String playSuccessSound() {
        return MusicResource.BASE_UNIVERSE_THEME_PATH + "SpaceStation/SpaceStationEnd.mp3";
    }

    @Override
    protected String playFailSound() {
        return MusicResource.THEME_END_FAIL;
    }

    @Override
    protected int failGapTime() {
        return 0;
    }

    @Override
    protected String loadSuccessFacePlay() {
        return PictureResource.BASE_UNIVERSE_PATH + "SpaceStation/SpaceStation.webp";
    }

    @Override
    protected String loadFailFacePlay() {
        return "";
    }

    @Override
    protected int successGapTime() {
        return 0;
    }

}