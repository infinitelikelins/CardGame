package com.bearya.robot.fairystory.walk.start;

import com.bearya.robot.base.play.FaceType;
import com.bearya.robot.base.util.CodeUtils;
import com.bearya.robot.fairystory.ui.res.FileResource;
import com.bearya.robot.fairystory.ui.res.IntroduceTime;
import com.bearya.robot.fairystory.ui.res.MusicResource;

public class SeafloorStart implements AbsStart {

    @Override
    public String playSound() {
        return MusicResource.SeafloorStartPlaySound;
    }

    @Override
    public String facePath() {
        return FileResource.BASE_PATH + "story/introduce/seafloor";
    }

    @Override
    public FaceType defineType() {
        return FaceType.Frame;
    }

    @Override
    public int gapTime() {
        return IntroduceTime.treasureStartTime;
    }

    @Override
    public String travelReady() {
        return MusicResource.BASE_MAIN_PATH + CodeUtils.oneOf("w_ready_treasure1.mp3", "w_ready_treasure2.mp3", "w_ready_treasure3.mp3");
    }

}