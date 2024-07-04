package com.bearya.robot.fairystory.walk.start;

import com.bearya.robot.base.play.FaceType;
import com.bearya.robot.fairystory.ui.res.MusicResource;
import com.bearya.robot.fairystory.ui.res.PictureResource;

public class AstronautStart implements AbsStart {

    @Override
    public String playSound() {
        return MusicResource.BASE_UNIVERSE_THEME_PATH + "Astronaut/AstronautStart.mp3";
    }

    @Override
    public String facePath() {
        return PictureResource.BASE_UNIVERSE_PATH + "Astronaut/Astronaut.webp";
    }

    @Override
    public FaceType defineType() {
        return FaceType.Image;
    }

    @Override
    public int gapTime() {
        return 0;
    }

    @Override
    public String travelReady() {
        return "music/zh/w_ready_treasure3.mp3";
    }
}
