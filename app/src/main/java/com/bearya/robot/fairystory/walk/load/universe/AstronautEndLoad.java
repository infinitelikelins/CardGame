package com.bearya.robot.fairystory.walk.load.universe;

import com.bearya.robot.base.play.FaceType;
import com.bearya.robot.fairystory.ui.res.MusicResource;
import com.bearya.robot.fairystory.ui.res.PictureResource;
import com.bearya.robot.fairystory.walk.load.EndLoad;

public class AstronautEndLoad extends EndLoad {

    public static final int START_OID = 57000;//启动点码
    public static final String NAME = "了不起的宇航员";

    public AstronautEndLoad() {
        super(START_OID);
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String[] getEquipmentLoads() {
        return new String[]{
                AstronautTrainLoad.NAME, // 航天员的训练
                AstronautLifeLoad.NAME, // 航天员在空间站里生活
                AstronautLoad.NAME // 航天员
        };
    }

    @Override
    protected FaceType defineType() {
        return FaceType.Image;
    }


    @Override
    protected String loadSuccessFacePlay() {
        return  PictureResource.BASE_UNIVERSE_PATH + "Astronaut/Astronaut.webp";
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
        return MusicResource.BASE_UNIVERSE_THEME_PATH + "Astronaut/AstronautEnd.mp3";
    }

    @Override
    protected String playFailSound() {
        return MusicResource.THEME_END_FAIL;
    }

    @Override
    protected int failGapTime() {
        return 0;
    }

}