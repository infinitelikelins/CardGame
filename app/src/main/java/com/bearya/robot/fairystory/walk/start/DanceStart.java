package com.bearya.robot.fairystory.walk.start;

import com.bearya.robot.base.play.FaceType;
import com.bearya.robot.base.util.CodeUtils;
import com.bearya.robot.fairystory.ui.res.FileResource;
import com.bearya.robot.fairystory.ui.res.IntroduceTime;
import com.bearya.robot.fairystory.ui.res.MusicResource;

public class DanceStart implements AbsStart {

    @Override
    public String playSound() {
        return MusicResource.DanceStartPlaySound;
    }

    @Override
    public String facePath() {
        return FileResource.BASE_PATH + "story/introduce/dance";
    }

    @Override
    public FaceType defineType() {
        return FaceType.Frame;
    }

    @Override
    public int gapTime() {
        return IntroduceTime.ballStartTime;
    }

    @Override
    public String travelReady() {
        return MusicResource.BASE_MAIN_PATH + CodeUtils.oneOf("w_ready_ball1.mp3", "w_ready_ball2.mp3", "w_ready_ball3.mp3");
    }

}