package com.bearya.robot.fairystory.walk.subjects;

import com.bearya.robot.fairystory.ui.res.MusicResource;
import com.bearya.robot.fairystory.walk.car.LoadMgr;
import com.bearya.robot.fairystory.walk.load.EndLoad;
import com.bearya.robot.fairystory.walk.load.festival.FestivalEndLoad;
import com.bearya.robot.fairystory.walk.start.AbsStart;
import com.bearya.robot.fairystory.walk.start.FestivalDreamStart;

public class FestivalDreamSubject  implements AbsSubject{

    public static final String NAME = "传统节日创想天地";

    @Override
    public String name() {
        return NAME;
    }

    @Override
    public String type() {
        return "FestivalDream";
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
        return new FestivalDreamStart();
    }

    @Override
    public EndLoad end() {
        return (EndLoad) LoadMgr.getInstance().getLoad(FestivalEndLoad.NAME);
    }

}
