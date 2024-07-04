package com.bearya.robot.fairystory.walk.subjects;

import com.bearya.robot.R;
import com.bearya.robot.fairystory.ui.res.MusicResource;
import com.bearya.robot.fairystory.walk.load.EndLoad;
import com.bearya.robot.fairystory.walk.start.AbsStart;
import com.bearya.robot.fairystory.walk.start.AstronautStart;

public class AstronautSubject implements AbsSubject {

    public static final String NAME = "了不起的航天员";

    @Override
    public String name() {
        return NAME;
    }

    @Override
    public String type() {
        return "Astronaut";
    }

    @Override
    public int res() {
        return R.mipmap.view_c;
    }

    @Override
    public String travel() {
        return MusicResource.TRAVEL;
    }

    @Override
    public AbsStart start() {
        return new AstronautStart();
    }

    @Override
    public EndLoad end() {
        return null;
    }
}