package com.bearya.robot.fairystory.walk.subjects;

import com.bearya.robot.fairystory.ui.res.MusicResource;
import com.bearya.robot.fairystory.ui.res.PictureResource;
import com.bearya.robot.fairystory.walk.car.LoadMgr;
import com.bearya.robot.fairystory.walk.load.EndLoad;
import com.bearya.robot.fairystory.walk.load.festival.SpringEndLoad;
import com.bearya.robot.fairystory.walk.start.AbsStart;
import com.bearya.robot.fairystory.walk.start.SpringStart;

public class SpringSubject extends AbsSubject {

    public static final String NAME = "春节";

    @Override
    public String name() {
        return NAME;
    }

    @Override
    public String type() {
        return "Spring";
    }

    @Override
    public String tabImage() {
        return PictureResource.BASE_FESTIVAL_PATH + "Spring/SpringTab.webp";
    }

    @Override
    public String travel() {
        return MusicResource.BASE_MAIN_PATH + "ball_walk.mp3";
    }

    @Override
    public AbsStart start() {
        return new SpringStart();
    }

    @Override
    public EndLoad end() {
        return (EndLoad) LoadMgr.getInstance().getLoad(SpringEndLoad.NAME);
    }

}