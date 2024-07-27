package com.bearya.robot.fairystory.walk.subjects;

import com.bearya.robot.fairystory.ui.res.MusicResource;
import com.bearya.robot.fairystory.ui.res.PictureResource;
import com.bearya.robot.fairystory.walk.car.LoadMgr;
import com.bearya.robot.fairystory.walk.load.EndLoad;
import com.bearya.robot.fairystory.walk.load.story.CastleEndLoad;
import com.bearya.robot.fairystory.walk.start.AbsStart;
import com.bearya.robot.fairystory.walk.start.DanceStart;

public class CastleSubject implements AbsSubject {

    public static final String NAME = "梦幻舞会";

    @Override
    public String name() {
        return NAME;
    }

    @Override
    public String type() {
        return "Castle";
    }

    @Override
    public String tabImage() {
        return PictureResource.BASE_STORY_PATH + "Castle/CastleTab.webp";
    }

    @Override
    public String travel() {
        return MusicResource.BASE_MAIN_PATH + "ball_walk.mp3";
    }

    @Override
    public AbsStart start() {
        return new DanceStart();
    }

    @Override
    public EndLoad end() {
        return (EndLoad) LoadMgr.getInstance().getLoad(CastleEndLoad.NAME);
    }

}
