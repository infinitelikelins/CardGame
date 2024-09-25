package com.bearya.robot.fairystory.walk.subjects;

import com.bearya.robot.fairystory.ui.res.MusicResource;
import com.bearya.robot.fairystory.ui.res.PictureResource;
import com.bearya.robot.fairystory.walk.car.LoadMgr;
import com.bearya.robot.fairystory.walk.load.EndLoad;
import com.bearya.robot.fairystory.walk.load.story.MineEndLoad;
import com.bearya.robot.fairystory.walk.start.AbsStart;
import com.bearya.robot.fairystory.walk.start.SeafloorStart;

public class TreasureSubject extends AbsSubject {

    public static final String NAME = "奇幻寻宝";

    @Override
    public String name() {
        return NAME;
    }

    @Override
    public String type() {
        return "Treasure";
    }

    @Override
    public String tabImage() {
        return PictureResource.BASE_STORY_PATH + "Treasure/TreasureTab.webp";
    }

    @Override
    public String travel() {
        return MusicResource.BASE_MAIN_PATH + "treasure_walk.mp3";
    }

    @Override
    public AbsStart start() {
        return new SeafloorStart();
    }

    @Override
    public EndLoad end() {
        return (EndLoad) LoadMgr.getInstance().getLoad(MineEndLoad.NAME);
    }

}