package com.bearya.robot.fairystory.walk.load.festival;

import com.bearya.robot.base.play.FaceType;
import com.bearya.robot.fairystory.ui.res.MusicResource;
import com.bearya.robot.fairystory.ui.res.PictureResource;
import com.bearya.robot.fairystory.walk.load.EndLoad;

public class WinterEndLoad extends EndLoad {

    public static final int START_OID = 35400;//启动点码
    public static final String NAME = "冬至终点";

    public WinterEndLoad() {
        super(START_OID);
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String[] getEquipmentLoads() {
        return new String[]{
                WinterKnowledgeLoad.NAME,
                WinterGameLoad.NAME,
                WinterCustomLoad.NAME,
        };
    }

    @Override
    protected FaceType defineType() {
        return FaceType.Image;
    }

    @Override
    protected String loadSuccessFacePlay() {
        return PictureResource.BASE_FESTIVAL_PATH + "WinterSolstice/WinterSolstice.webp";
    }

    @Override
    protected String loadFailFacePlay() {
        return PictureResource.BASE_FESTIVAL_PATH + "WinterSolstice/WinterSolstice.webp";
    }

    @Override
    protected int successGapTime() {
        return 0;
    }

    @Override
    protected String playSuccessSound() {
        return MusicResource.BASE_FESTIVAL_THEME_PATH + "WinterSolstice/WinterSolsticeEndSuccess.mp3";
    }

    @Override
    protected String playFailSound() {
        return MusicResource.BASE_FESTIVAL_THEME_PATH + "WinterSolstice/WinterSolsticeEndFail.mp3";
    }

    @Override
    protected int failGapTime() {
        return 0;
    }
}
