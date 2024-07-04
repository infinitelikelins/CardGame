package com.bearya.robot.fairystory.walk.subjects;

import com.bearya.robot.R;
import com.bearya.robot.fairystory.ui.res.MusicResource;
import com.bearya.robot.fairystory.walk.load.EndLoad;
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
    public int res() {
        return R.mipmap.view_b;
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
        return null;
    }
}
