package com.bearya.robot.fairystory.walk.load.festival;

import com.bearya.robot.base.play.FaceType;
import com.bearya.robot.fairystory.ui.res.MusicResource;
import com.bearya.robot.fairystory.ui.res.PictureResource;
import com.bearya.robot.fairystory.walk.load.EndLoad;

public class DoubleNinthEndLoad extends EndLoad {

    public static final int START_OID = 22600;//启动点码
    public static final String NAME = "重阳节终点";

    public DoubleNinthEndLoad() {
        super(START_OID);
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String[] getEquipmentLoads() {
        return new String[]{
                DoubleNinthCustomLoad.NAME,
                DoubleNinthGameLoad.NAME,
                DoubleNinthFoodsLoad.NAME,
                DoubleNinthKnowledgeLoad.NAME
        };
    }

    @Override
    protected FaceType defineType() {
        return FaceType.Image;
    }

    @Override
    protected String loadSuccessFacePlay() {
        return PictureResource.BASE_FESTIVAL_PATH + "DoubleNinth/DoubleNinth.webp";
    }

    @Override
    protected String loadFailFacePlay() {
        return PictureResource.BASE_FESTIVAL_PATH + "DoubleNinth/DoubleNinth.webp";
    }

    @Override
    protected int successGapTime() {
        return 0;
    }

    @Override
    protected String playSuccessSound() {
        return MusicResource.BASE_FESTIVAL_THEME_PATH + "DoubleNinth/DoubleNinthEndSuccess.mp3";
    }

    @Override
    protected String playFailSound() {
        return MusicResource.BASE_FESTIVAL_THEME_PATH + "DoubleNinth/DoubleNinthEndFail.mp3";
    }

    @Override
    protected int failGapTime() {
        return 0;
    }

}
