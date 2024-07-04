package com.bearya.robot.fairystory.walk.load.universe;

import com.bearya.robot.base.play.FaceType;
import com.bearya.robot.fairystory.ui.res.VideoResource;
import com.bearya.robot.fairystory.walk.load.EquipmentLoad;

public class AstronautLoad extends EquipmentLoad {

    public static final int START_OID = 50700;//启动点码
    public static final String NAME = "航天员";

    public AstronautLoad() {
        super(START_OID);
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    protected String loadFacePlay() {
        return VideoResource.Astronaut;
    }

    @Override
    protected FaceType defineType() {
        return FaceType.Video;
    }

}