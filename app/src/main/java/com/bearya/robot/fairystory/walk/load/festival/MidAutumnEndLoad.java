package com.bearya.robot.fairystory.walk.load.festival;

import com.bearya.robot.base.play.FaceType;
import com.bearya.robot.fairystory.ui.res.MusicResource;
import com.bearya.robot.fairystory.ui.res.PictureResource;
import com.bearya.robot.fairystory.walk.load.EndLoad;

public class MidAutumnEndLoad extends EndLoad {

    public static final int START_OID = 31800;//启动点码
    public static final String NAME = "中秋节终点";

    public MidAutumnEndLoad() {
        super(START_OID);
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String[] getEquipmentLoads() {
        return new String[]{
                MidAutumnCustomLoad.NAME,
                MidAutumnKnowledgeLoad.NAME,
                MidAutumnMoonLoad.NAME,
                MidAutumnGardenPartyLoad.NAME
        };
    }

    @Override
    protected FaceType defineType() {
        return FaceType.Image;
    }

    @Override
    protected String loadSuccessFacePlay() {
        return PictureResource.BASE_FESTIVAL_PATH + "MidAutumn/MidAutumn.webp";
    }

    @Override
    protected String loadFailFacePlay() {
        return PictureResource.BASE_FESTIVAL_PATH + "MidAutumn/MidAutumn.webp";
    }

    @Override
    protected int successGapTime() {
        return 0;
    }

    @Override
    protected String playSuccessSound() {
        return MusicResource.BASE_FESTIVAL_THEME_PATH + "MidAutumn/MidAutumnEndSuccess.mp3";
    }

    @Override
    protected String playFailSound() {
        return MusicResource.BASE_FESTIVAL_THEME_PATH + "MidAutumn/MidAutumnEndFail.mp3";
    }

    @Override
    protected int failGapTime() {
        return 0;
    }
}
