package com.bearya.robot.fairystory.walk.subjects;

import com.bearya.robot.fairystory.ui.res.MusicResource;
import com.bearya.robot.fairystory.ui.res.PictureResource;
import com.bearya.robot.fairystory.walk.car.LoadMgr;
import com.bearya.robot.fairystory.walk.load.EndLoad;
import com.bearya.robot.fairystory.walk.load.story.DragonEndLoad;
import com.bearya.robot.fairystory.walk.start.AbsStart;
import com.bearya.robot.fairystory.walk.start.HeroStart;

public class DragonSubject implements AbsSubject{

    public static final String NAME = "英雄无敌";

    @Override
    public String name() {
        return NAME;
    }

    @Override
    public String type() {
        return "Dragon";
    }

    @Override
    public String tabImage() {
        return PictureResource.BASE_STORY_PATH + "Dragon/DragonTab.webp";
    }

    @Override
    public String travel() {
        return MusicResource.BASE_MAIN_PATH + "hero_walk.mp3";
    }

    @Override
    public AbsStart start() {
        return new HeroStart();
    }

    @Override
    public EndLoad end() {
        return (EndLoad) LoadMgr.getInstance().getLoad(DragonEndLoad.NAME);
    }

}
