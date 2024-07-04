package com.bearya.robot.fairystory.walk.load.universe;

import com.bearya.robot.base.play.FaceType;
import com.bearya.robot.fairystory.ui.res.VideoResource;
import com.bearya.robot.fairystory.walk.load.EquipmentLoad;

public class PlanetCharacteristicsLoad extends EquipmentLoad {

    public static final int START_OID = 34500;//启动点码

    public static final String NAME = "八大行星的特点";

    public PlanetCharacteristicsLoad() {
        super(START_OID);
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    protected String loadFacePlay() {
        return VideoResource.PlanetCharacteristics;
    }

    @Override
    protected FaceType defineType() {
        return FaceType.Video;
    }

}
