package com.bearya.robot.fairystory.walk.load.universe;

import com.bearya.robot.base.play.FaceType;
import com.bearya.robot.fairystory.ui.res.MusicResource;
import com.bearya.robot.fairystory.ui.res.PictureResource;
import com.bearya.robot.fairystory.walk.load.EndLoad;

public class PlanetSecretEndLoad extends EndLoad {

    public static final int START_OID = 10900;//启动点码
    public static final String NAME = "行星的秘密";

    public PlanetSecretEndLoad() {
        super(START_OID);
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String[] getEquipmentLoads() {
        return new String[]{
                PlanetMotionLoad.NAME, // 行星的运动
                PlanetCharacteristicsLoad.NAME, // 八大行星的特点
                PlanetLoad.NAME // 认识八大行星
        };
    }

    @Override
    protected FaceType defineType() {
        return FaceType.Image;
    }

    @Override
    protected String loadSuccessFacePlay() {
        return  PictureResource.BASE_UNIVERSE_PATH + "PlanetSecret/PlanetSecret.webp";
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
    protected String playSuccessSound() {
        return MusicResource.BASE_UNIVERSE_THEME_PATH + "PlanetSecret/PlanetSecretEnd.mp3";
    }

    @Override
    protected String playFailSound() {
        return MusicResource.BASE_UNIVERSE_THEME_PATH + "PlanetSecret/PlanetSecretEnd.mp3";
    }

    @Override
    protected int failGapTime() {
        return 0;
    }

}