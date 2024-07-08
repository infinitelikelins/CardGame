package com.bearya.robot.fairystory.walk.subjects;

import com.bearya.robot.fairystory.ui.res.MusicResource;
import com.bearya.robot.fairystory.walk.car.LoadMgr;
import com.bearya.robot.fairystory.walk.load.EndLoad;
import com.bearya.robot.fairystory.walk.load.universe.FreeEndLoad;
import com.bearya.robot.fairystory.walk.start.AbsStart;
import com.bearya.robot.fairystory.walk.start.UniverseDreamStart;

public class UniverseDreamSubject implements AbsSubject{

    public static final String NAME = "童话世界创想天地";

    @Override
    public String name() {
        return NAME;
    }

    @Override
    public String type() {
        return "UniverseDream";
    }

    @Override
    public String tabImage() {
        return null;
    }

    @Override
    public String travel() {
        return MusicResource.TRAVEL;
    }

    @Override
    public AbsStart start() {
        return new UniverseDreamStart();
    }

    @Override
    public EndLoad end() {
        return (EndLoad) LoadMgr.getInstance().getLoad(FreeEndLoad.NAME);
    }

}