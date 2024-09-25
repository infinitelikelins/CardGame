package com.bearya.robot.fairystory.ui.station;

import com.bearya.robot.fairystory.ui.res.MusicResource;
import com.bearya.robot.fairystory.ui.res.PictureResource;
import com.bearya.robot.fairystory.ui.res.VideoResource;

public class LibItem {

    private String name;
    private String image;
    private String sound;
    private String video;

    public String getName() {
        return name;
    }

    public String getImage() {
        return PictureResource.BASE_PATH + image;
    }

    public String getSound() {
        return MusicResource.BASE_PATH + sound;
    }

    public String getVideo() {
        return VideoResource.BASE_PATH + video;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public void setVideo(String video) {
        this.video = video;
    }

}
