package com.bearya.robot.fairystory.walk.load.universe;

import com.bearya.robot.base.play.FaceType;
import com.bearya.robot.fairystory.ui.res.VideoResource;
import com.bearya.robot.fairystory.walk.load.EquipmentLoad;

public class RocketLaunchLoad extends EquipmentLoad {

    public static final int START_OID = 31800;
    public static final String NAME = "火箭发射";

    public RocketLaunchLoad() {
        super(START_OID);
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    protected String loadFacePlay() {
        return VideoResource.RocketLaunch;
    }

    @Override
    protected FaceType defineType() {
        return FaceType.Video;
    }

}