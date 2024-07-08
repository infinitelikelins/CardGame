package com.bearya.robot.fairystory.walk.load.universe;

import com.bearya.robot.base.play.FaceType;
import com.bearya.robot.fairystory.ui.res.MusicResource;
import com.bearya.robot.fairystory.ui.res.PictureResource;
import com.bearya.robot.fairystory.walk.load.EndLoad;

public class RocketEndLoad extends EndLoad {

    public static final int START_OID = 32700;// 启动点码 (先于跳跳镇的终点码值重合)
    public static final String NAME = "飞天神州";

    public RocketEndLoad() {
        super(START_OID);
    }

    @Override
    public String[] getEquipmentLoads() {
        return new String[]{
                RocketPrincipleLoad.NAME, // 发射原理
                RocketLaunchLoad.NAME, // 火箭发射
                RocketUnderstandLoad.NAME // 认识火箭
        };
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    protected FaceType defineType() {
        return FaceType.Image;
    }

    @Override
    protected String loadSuccessFacePlay() {
        return PictureResource.BASE_UNIVERSE_PATH + "Spaceship/Spaceship.webp";
    }

    @Override
    protected String loadFailFacePlay() {
        return PictureResource.BASE_UNIVERSE_PATH + "Spaceship/Spaceship.webp";
    }

    @Override
    protected int successGapTime() {
        return 0;
    }

    @Override
    protected String playSuccessSound() {
        return MusicResource.BASE_UNIVERSE_THEME_PATH + "Spaceship/SpaceshipEnd.mp3";
    }

    @Override
    protected String playFailSound() {
        return MusicResource.BASE_UNIVERSE_THEME_PATH + "Spaceship/SpaceshipEnd.mp3";
    }

    @Override
    protected int failGapTime() {
        return 0;
    }

}