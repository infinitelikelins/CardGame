package com.bearya.robot.fairystory.walk.load.universe;

import com.bearya.robot.base.play.FaceType;
import com.bearya.robot.fairystory.ui.res.VideoResource;
import com.bearya.robot.fairystory.walk.load.EquipmentLoad;

public class SpaceStationRoleLoad extends EquipmentLoad {

    public static final int START_OID = 47100;//启动点码

    public static final String NAME = "空间站的作用";

    public SpaceStationRoleLoad() {
        super(START_OID);
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    protected String loadFacePlay() {
        return VideoResource.SpaceStationRole;
    }

    @Override
    protected FaceType defineType() {
        return FaceType.Video;
    }
}
