package com.bearya.robot.fairystory.walk.load.story;

import com.bearya.robot.fairystory.ui.res.FileResource;
import com.bearya.robot.fairystory.ui.res.IntroduceTime;
import com.bearya.robot.fairystory.ui.res.MusicResource;
import com.bearya.robot.fairystory.walk.load.NoEntryLoad;

public class VolcanicLoad extends NoEntryLoad {

    public static final int START_OID = 31800;//启动点码
    public static final String NAME = "火山地垫";

    public VolcanicLoad() {
        super(START_OID);
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    protected String loadFacePlay() {
        return FileResource.BASE_PATH + "story/noEntry/volcano";
    }

    @Override
    protected String loadPlaySound() {
        return MusicResource.BASE_PATH + "story/noEntry/music/volcano_fail.mp3";
    }

    @Override
    protected int loadPlayFaceTime() {
        return IntroduceTime.volcanicPlayTime;
    }

}