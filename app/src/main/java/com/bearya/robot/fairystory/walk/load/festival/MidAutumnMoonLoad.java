package com.bearya.robot.fairystory.walk.load.festival;

import com.bearya.robot.base.play.FacePlay;
import com.bearya.robot.base.play.FaceType;
import com.bearya.robot.base.play.PlayData;
import com.bearya.robot.base.util.CodeUtils;
import com.bearya.robot.fairystory.ui.res.MusicResource;
import com.bearya.robot.fairystory.ui.res.PictureResource;
import com.bearya.robot.fairystory.ui.res.VideoResource;
import com.bearya.robot.fairystory.walk.load.EquipmentLoad;

public class MidAutumnMoonLoad extends EquipmentLoad {

    public static final int START_OID = 30000;//启动点码
    public static final String NAME = "月亮的变化";

    public MidAutumnMoonLoad() {
        super(START_OID);
    }

    @Override
    protected PlayData onNewLoadPlayData() {
        return CodeUtils.oneOf(
                new PlayData(new FacePlay(VideoResource.FESTIVAL_VIDEO_BASE_PATH + "月亮的变化.mp4", FaceType.Video)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "上弦月.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "上弦月.webp", FaceType.Image)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "下弦月.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "下弦月.webp", FaceType.Image)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "亏凸月.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "亏凸月.webp", FaceType.Image)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "峨眉月.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "峨眉月.webp", FaceType.Image)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "新月.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "新月.webp", FaceType.Image)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "残月.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "残月.webp", FaceType.Image)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "满月.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "满月.webp", FaceType.Image)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "盈凸月.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "盈凸月.webp", FaceType.Image))
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