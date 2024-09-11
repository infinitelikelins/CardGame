package com.bearya.robot.fairystory.walk.load.festival;

import com.bearya.robot.base.play.FacePlay;
import com.bearya.robot.base.play.FaceType;
import com.bearya.robot.base.play.PlayData;
import com.bearya.robot.base.util.CodeUtils;
import com.bearya.robot.fairystory.ui.res.MusicResource;
import com.bearya.robot.fairystory.ui.res.PictureResource;
import com.bearya.robot.fairystory.ui.res.VideoResource;
import com.bearya.robot.fairystory.walk.load.EquipmentLoad;

public class DoubleNinthCustomLoad extends EquipmentLoad {

    public static final int START_OID = 19900;//启动点码
    public static final String NAME = "重阳的习俗";

    public DoubleNinthCustomLoad() {
        super(START_OID);
    }

    @Override
    protected PlayData onNewLoadPlayData() {
        return CodeUtils.oneOf(
                new PlayData(new FacePlay(VideoResource.FESTIVAL_VIDEO_BASE_PATH + "插茱萸.mp4", FaceType.Video)),
                new PlayData(new FacePlay(VideoResource.FESTIVAL_VIDEO_BASE_PATH + "登高.mp4", FaceType.Video)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "插茱萸.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "插茱萸.webp", FaceType.Image)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "晒秋.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "晒秋.webp", FaceType.Image)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "登高.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "登高.webp", FaceType.Image)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "赏菊.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "赏菊.webp", FaceType.Image)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "饮菊花酒.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "饮菊花酒.webp", FaceType.Image))
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
