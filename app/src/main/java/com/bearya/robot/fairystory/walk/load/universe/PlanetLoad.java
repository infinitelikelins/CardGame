package com.bearya.robot.fairystory.walk.load.universe;

import com.bearya.robot.base.play.FaceType;
import com.bearya.robot.fairystory.ui.res.VideoResource;
import com.bearya.robot.fairystory.walk.load.EquipmentLoad;

public class PlanetLoad extends EquipmentLoad {

    public static final int START_OID = 35400;//启动点码
    public static final String NAME = "认识八大行星";

    public PlanetLoad() {
        super(START_OID);
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    protected String loadFacePlay() {
        return VideoResource.Planet;
    }

    @Override
    protected FaceType defineType() {
        return FaceType.Video;
    }

}