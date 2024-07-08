package com.bearya.robot.fairystory.walk.start;

import com.bearya.robot.base.play.FaceType;
import com.bearya.robot.fairystory.ui.res.MusicResource;

public class UniverseDreamStart implements AbsStart {

    @Override
    public String playSound() {
        return null;
    }

    @Override
    public String facePath() {
        return null;
    }

    @Override
    public FaceType defineType() {
        return FaceType.Lottie;
    }

    @Override
    public int gapTime() {
        return 0;
    }

    @Override
    public String travelReady() {
        return MusicResource.BASE_MAIN_PATH + "w_ready_treasure3.mp3";
    }

}