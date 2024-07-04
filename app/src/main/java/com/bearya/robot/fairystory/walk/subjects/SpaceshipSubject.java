package com.bearya.robot.fairystory.walk.subjects;

import com.bearya.robot.R;
import com.bearya.robot.fairystory.ui.res.MusicResource;
import com.bearya.robot.fairystory.walk.load.EndLoad;
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
    public int res() {
        return R.mipmap.view_d;
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
        return null;
    }
}
