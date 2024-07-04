package com.bearya.robot.fairystory.walk.load.universe;

import com.bearya.robot.base.play.FaceType;
import com.bearya.robot.fairystory.ui.res.VideoResource;
import com.bearya.robot.fairystory.walk.load.EquipmentLoad;

public class RocketUnderstandLoad extends EquipmentLoad {

    public static final int START_OID = 30000;
    public static final String NAME = "认识火箭";

    public RocketUnderstandLoad() {
        super(START_OID);
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    protected String loadFacePlay() {
        return VideoResource.RocketUnderstand;
    }

    @Override
    protected FaceType defineType() {
        return FaceType.Video;
    }

}