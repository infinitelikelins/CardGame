package com.bearya.robot.fairystory.walk.subjects;

import com.bearya.robot.R;
import com.bearya.robot.fairystory.ui.res.MusicResource;
import com.bearya.robot.fairystory.walk.load.EndLoad;
import com.bearya.robot.fairystory.walk.start.AbsStart;
import com.bearya.robot.fairystory.walk.start.PlanetSecretStart;

public class PlanetSecretSubject implements AbsSubject {

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
    public int res() {
        return R.mipmap.view_a;
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
        return null;
    }
}
