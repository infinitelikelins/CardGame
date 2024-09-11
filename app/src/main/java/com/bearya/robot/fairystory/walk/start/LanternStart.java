package com.bearya.robot.fairystory.walk.start;

import com.bearya.robot.base.play.FaceType;
import com.bearya.robot.fairystory.ui.res.MusicResource;
import com.bearya.robot.fairystory.ui.res.PictureResource;

public class LanternStart implements AbsStart{

    @Override
    public String playSound() {
        return MusicResource.BASE_FESTIVAL_THEME_PATH + "Lantern/LanternStart.mp3";
    }

    @Override
    public String facePath() {
        return PictureResource.BASE_FESTIVAL_PATH + "Lantern/Lantern.webp";
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
