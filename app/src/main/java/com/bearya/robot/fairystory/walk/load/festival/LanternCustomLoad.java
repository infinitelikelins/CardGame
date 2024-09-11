package com.bearya.robot.fairystory.walk.load.festival;

import com.bearya.robot.base.play.FacePlay;
import com.bearya.robot.base.play.FaceType;
import com.bearya.robot.base.play.PlayData;
import com.bearya.robot.base.util.CodeUtils;
import com.bearya.robot.fairystory.ui.res.MusicResource;
import com.bearya.robot.fairystory.ui.res.PictureResource;
import com.bearya.robot.fairystory.ui.res.VideoResource;
import com.bearya.robot.fairystory.walk.load.EquipmentLoad;

public class LanternCustomLoad extends EquipmentLoad {

    public static final int START_OID = 5500;//启动点码
    public static final String NAME = "元宵的习俗";

    public LanternCustomLoad() {
        super(START_OID);
    }

    @Override
    protected PlayData onNewLoadPlayData() {
        return CodeUtils.oneOf(
                new PlayData(new FacePlay(VideoResource.FESTIVAL_VIDEO_BASE_PATH + "吃元宵.mp4", FaceType.Video)),
                new PlayData(new FacePlay(VideoResource.FESTIVAL_VIDEO_BASE_PATH + "舞狮.mp4", FaceType.Video)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "习俗介绍.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "习俗介绍.webp", FaceType.Image)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "元宵的由来.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "元宵的由来.webp", FaceType.Image)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "踩高跷.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "踩高跷.webp", FaceType.Image)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "闹花灯.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "闹花灯.webp", FaceType.Image))
        );
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    protected String loadFacePlay() {
        return "";
    }

    @Override
    protected String playSound() {
        return "";
    }

    @Override
    protected FaceType defineType() {
        return FaceType.Image;
    }

}
