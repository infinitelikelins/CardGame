package com.bearya.robot.fairystory.walk.subjects;

import com.bearya.robot.R;
import com.bearya.robot.fairystory.walk.car.LoadMgr;
import com.bearya.robot.fairystory.walk.load.EndLoad;
import com.bearya.robot.fairystory.walk.load.story.MineEndLoad;
import com.bearya.robot.fairystory.walk.start.AbsStart;
import com.bearya.robot.fairystory.walk.start.SeafloorStart;

public class TreasureSubject implements AbsSubject {

    public static final String NAME = "宝藏岛";

    @Override
    public String name() {
        return NAME;
    }

    @Override
    public String type() {
        return "Treasure";
    }

    @Override
    public int res() {
        return R.mipmap.view_b;
    }

    @Override
    public String travel() {
        return "music/zh/treasure_walk.mp3";
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
