package com.bearya.robot.fairystory.walk.load.universe;

import com.bearya.robot.base.play.FaceType;
import com.bearya.robot.fairystory.ui.res.VideoResource;
import com.bearya.robot.fairystory.walk.load.EquipmentLoad;

public class RocketPrincipleLoad extends EquipmentLoad {

    public static final int START_OID = 30900;
    public static final String NAME = "发射原理";

    public RocketPrincipleLoad() {
        super(START_OID);
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    protected String loadFacePlay() {
        return VideoResource.RocketPrinciple;
    }

    @Override
    protected FaceType defineType() {
        return FaceType.Video;
    }

}