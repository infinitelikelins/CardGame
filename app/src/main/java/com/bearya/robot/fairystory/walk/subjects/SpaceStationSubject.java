package com.bearya.robot.fairystory.walk.subjects;

import com.bearya.robot.fairystory.ui.res.MusicResource;
import com.bearya.robot.fairystory.ui.res.PictureResource;
import com.bearya.robot.fairystory.walk.car.LoadMgr;
import com.bearya.robot.fairystory.walk.load.EndLoad;
import com.bearya.robot.fairystory.walk.load.universe.SpaceStationEndLoad;
import com.bearya.robot.fairystory.walk.start.AbsStart;
import com.bearya.robot.fairystory.walk.start.SpaceStationStart;

public class SpaceStationSubject implements AbsSubject{

    public static final String NAME = "有趣的空间站";

    @Override
    public String name() {
        return NAME;
    }

    @Override
    public String type() {
        return "SpaceStation";
    }

    @Override
    public String tabImage() {
        return PictureResource.BASE_UNIVERSE_PATH +  "SpaceStation/SpaceStationTab.webp";
    }

    @Override
    public String travel() {
        return MusicResource.TRAVEL;
    }

    @Override
    public AbsStart start() {
        return new SpaceStationStart();
    }

    @Override
    public EndLoad end() {
        return (EndLoad) LoadMgr.getInstance().getLoad(SpaceStationEndLoad.NAME);
    }

}