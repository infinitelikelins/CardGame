package com.bearya.robot.fairystory.walk.subjects;

import com.bearya.robot.R;
import com.bearya.robot.fairystory.walk.car.LoadMgr;
import com.bearya.robot.fairystory.walk.load.EndLoad;
import com.bearya.robot.fairystory.walk.load.story.DragonEndLoad;
import com.bearya.robot.fairystory.walk.start.AbsStart;
import com.bearya.robot.fairystory.walk.start.HeroStart;

public class DragonSubject implements AbsSubject{

    public static final String NAME = "恶龙谷";

    @Override
    public String name() {
        return NAME;
    }

    @Override
    public String type() {
        return "Dragon";
    }

    @Override
    public int res() {
        return R.mipmap.view_a;
    }

    @Override
    public String travel() {
        return "music/zh/hero_walk.mp3";
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
