package com.bearya.robot.fairystory.walk.start;

import com.bearya.robot.base.play.FaceType;
import com.bearya.robot.base.util.CodeUtils;
import com.bearya.robot.fairystory.ui.res.FileResource;
import com.bearya.robot.fairystory.ui.res.IntroduceTime;
import com.bearya.robot.fairystory.ui.res.MusicResource;

public class HeroStart implements AbsStart {

    @Override
    public String playSound() {
        return MusicResource.HeroStartPlaySound;
    }

    @Override
    public String facePath() {
        return FileResource.BASE_PATH + "story/introduce/hero";
    }

    @Override
    public FaceType defineType() {
        return FaceType.Frame;
    }

    @Override
    public int gapTime() {
        return IntroduceTime.heroStartTime;
    }

    @Override
    public String travelReady() {
        return CodeUtils.oneOf("music/zh/w_ready_hero1.mp3", "music/zh/w_ready_hero2.mp3", "music/zh/w_ready_hero3.mp3");
    }

}
