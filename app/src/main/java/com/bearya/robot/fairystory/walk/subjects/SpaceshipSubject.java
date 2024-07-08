package com.bearya.robot.fairystory.walk.subjects;

import com.bearya.robot.fairystory.ui.res.MusicResource;
import com.bearya.robot.fairystory.ui.res.PictureResource;
import com.bearya.robot.fairystory.walk.car.LoadMgr;
import com.bearya.robot.fairystory.walk.load.EndLoad;
import com.bearya.robot.fairystory.walk.load.universe.RocketEndLoad;
import com.bearya.robot.fairystory.walk.start.AbsStart;
import com.bearya.robot.fairystory.walk.start.SpaceshipStart;

public class SpaceshipSubject implements AbsSubject {

    public static final String NAME = "飞天神舟";

    @Override
    public String name() {
        return NAME;
    }

    @Override
    public String type() {
        return "Spaceship";
    }

    @Override
    public String tabImage() {
        return PictureResource.BASE_UNIVERSE_PATH + "Spaceship/SpaceshipTab.webp";
    }

    @Override
    public String travel() {
        return MusicResource.TRAVEL;
    }

    @Override
    public AbsStart start() {
        return new SpaceshipStart();
    }

    @Override
    public EndLoad end() {
        return (EndLoad) LoadMgr.getInstance().getLoad(RocketEndLoad.NAME);
    }
}
