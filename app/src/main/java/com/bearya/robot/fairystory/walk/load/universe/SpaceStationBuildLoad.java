package com.bearya.robot.fairystory.walk.load.universe;

import com.bearya.robot.base.play.FaceType;
import com.bearya.robot.fairystory.ui.res.VideoResource;
import com.bearya.robot.fairystory.walk.load.EquipmentLoad;

public class SpaceStationBuildLoad extends EquipmentLoad {

    public static final int START_OID = 46200;//启动点码
    public static final String NAME = "空间站的建造";

    public SpaceStationBuildLoad() {
        super(START_OID);
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    protected String loadFacePlay() {
        return VideoResource.SpaceStationBuild;
    }

    @Override
    protected FaceType defineType() {
        return FaceType.Video;
    }
}