package com.bearya.robot.fairystory.walk.start;

import com.bearya.robot.base.play.FaceType;
import com.bearya.robot.fairystory.ui.res.MusicResource;
import com.bearya.robot.fairystory.ui.res.PictureResource;

public class PlanetSecretStart implements AbsStart {

    @Override
    public String playSound() {
        return MusicResource.BASE_UNIVERSE_THEME_PATH + "PlanetSecret/PlanetSecretStart.mp3";
    }

    @Override
    public String facePath() {
        return PictureResource.BASE_UNIVERSE_PATH + "PlanetSecret/PlanetSecret.webp";
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
        return MusicResource.BASE_MAIN_PATH + "w_ready_treasure3.mp3";
    }
}