package com.bearya.robot.fairystory.walk.load.universe;

import com.bearya.robot.base.play.FaceType;
import com.bearya.robot.fairystory.ui.res.VideoResource;
import com.bearya.robot.fairystory.walk.load.EquipmentLoad;

public class AstronautTrainLoad extends EquipmentLoad {

    public static final int START_OID = 49800;//启动点码
    public static final String NAME = "航天员的训练";

    public AstronautTrainLoad() {
        super(START_OID);
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    protected String loadFacePlay() {
        return VideoResource.AstronautTrain;
    }

    @Override
    protected FaceType defineType() {
        return FaceType.Video;
    }

}