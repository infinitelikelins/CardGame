package com.bearya.robot.fairystory.walk.load.universe;

import com.bearya.robot.base.play.FaceType;
import com.bearya.robot.fairystory.ui.res.VideoResource;
import com.bearya.robot.fairystory.walk.load.EquipmentLoad;

public class PlanetMotionLoad extends EquipmentLoad {

    public static final int START_OID = 33600;//启动点码
    public static final String NAME = "行星的运动";

    public PlanetMotionLoad() {
        super(START_OID);
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    protected String loadFacePlay() {
        return VideoResource.PlanetMotion;
    }

    @Override
    protected FaceType defineType() {
        return FaceType.Video;
    }

}