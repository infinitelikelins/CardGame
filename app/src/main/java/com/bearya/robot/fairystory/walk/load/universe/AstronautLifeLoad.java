package com.bearya.robot.fairystory.walk.load.universe;

import com.bearya.robot.base.play.FaceType;
import com.bearya.robot.fairystory.ui.res.VideoResource;
import com.bearya.robot.fairystory.walk.load.EquipmentLoad;

public class AstronautLifeLoad extends EquipmentLoad {

    public static final int START_OID = 48900;//启动点码
    public static final String NAME = "航天员在空间站里生活";

    public AstronautLifeLoad() {
        super(START_OID);
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    protected String loadFacePlay() {
        return VideoResource.SpaceStationsLife;
    }

    @Override
    protected FaceType defineType() {
        return FaceType.Video;
    }

}