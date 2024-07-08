package com.bearya.robot.fairystory.walk.subjects;

import com.bearya.robot.fairystory.ui.res.MusicResource;
import com.bearya.robot.fairystory.walk.car.LoadMgr;
import com.bearya.robot.fairystory.walk.load.EndLoad;
import com.bearya.robot.fairystory.walk.load.story.IdeaEndLoad;
import com.bearya.robot.fairystory.walk.start.AbsStart;
import com.bearya.robot.fairystory.walk.start.StoryDreamStart;

public class StoryDreamSubject implements AbsSubject{

    public static final String NAME = "童话世界创想天地";

    @Override
    public String name() {
        return NAME;
    }

    @Override
    public String type() {
        return "StoryDream";
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
        return new StoryDreamStart();
    }

    @Override
    public EndLoad end() {
        return (EndLoad) LoadMgr.getInstance().getLoad(IdeaEndLoad.NAME);
    }

}
