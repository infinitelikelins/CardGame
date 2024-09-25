package com.bearya.robot.fairystory.walk.subjects;

import com.bearya.robot.fairystory.ui.res.MusicResource;
import com.bearya.robot.fairystory.ui.res.PictureResource;
import com.bearya.robot.fairystory.walk.car.LoadMgr;
import com.bearya.robot.fairystory.walk.load.EndLoad;
import com.bearya.robot.fairystory.walk.load.universe.PlanetSecretEndLoad;
import com.bearya.robot.fairystory.walk.start.AbsStart;
import com.bearya.robot.fairystory.walk.start.PlanetSecretStart;

public class PlanetSecretSubject extends AbsSubject {

    public static final String NAME = "行星的秘密";

    @Override
    public String name() {
        return NAME;
    }

    @Override
    public String type() {
        return "PlanetSecret";
    }

    @Override
    public String tabImage() {
        return PictureResource.BASE_UNIVERSE_PATH +  "PlanetSecret/PlanetSecretTab.webp";
    }

    @Override
    public String travel() {
        return MusicResource.TRAVEL;
    }

    @Override
    public AbsStart start() {
        return new PlanetSecretStart();
    }

    @Override
    public EndLoad end() {
        return (EndLoad) LoadMgr.getInstance().getLoad(PlanetSecretEndLoad.NAME);
    }

}
