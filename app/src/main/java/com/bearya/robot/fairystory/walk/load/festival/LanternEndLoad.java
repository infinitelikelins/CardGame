package com.bearya.robot.fairystory.walk.load.festival;

import com.bearya.robot.base.play.FaceType;
import com.bearya.robot.fairystory.ui.res.MusicResource;
import com.bearya.robot.fairystory.ui.res.PictureResource;
import com.bearya.robot.fairystory.walk.load.EndLoad;

public class LanternEndLoad extends EndLoad {

    public static final int START_OID = 8200;//启动点码
    public static final String NAME = "元宵节终点";

    public LanternEndLoad() {
        super(START_OID);
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String[] getEquipmentLoads() {
        return new String[]{
                LanternCustomLoad.NAME,
                LanternFoodsLoad.NAME,
                LanternLampLoad.NAME,
        };
    }

    @Override
    protected FaceType defineType() {
        return FaceType.Image;
    }

    @Override
    protected String loadSuccessFacePlay() {
        return PictureResource.BASE_FESTIVAL_PATH + "Lantern/Lantern.webp";
    }

    @Override
    protected String loadFailFacePlay() {
        return PictureResource.BASE_FESTIVAL_PATH + "Lantern/Lantern.webp";
    }

    @Override
    protected int successGapTime() {
        return 0;
    }

    @Override
    protected String playSuccessSound() {
        return MusicResource.BASE_FESTIVAL_THEME_PATH + "Lantern/LanternEndSuccess.mp3";
    }

    @Override
    protected String playFailSound() {
        return MusicResource.BASE_FESTIVAL_THEME_PATH + "Lantern/LanternEndFail.mp3";
    }
    @Override
    protected int failGapTime() {
        return 0;
    }
}
