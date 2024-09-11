package com.bearya.robot.fairystory.walk.load.festival;

import com.bearya.robot.base.play.FacePlay;
import com.bearya.robot.base.play.FaceType;
import com.bearya.robot.base.play.PlayData;
import com.bearya.robot.base.util.CodeUtils;
import com.bearya.robot.fairystory.ui.res.MusicResource;
import com.bearya.robot.fairystory.ui.res.PictureResource;
import com.bearya.robot.fairystory.ui.res.VideoResource;
import com.bearya.robot.fairystory.walk.load.EquipmentLoad;

public class SpringFoodsLoad extends EquipmentLoad {

    public static final int START_OID = 2800;//启动点码
    public static final String NAME = "春节的美食";

    public SpringFoodsLoad() {
        super(START_OID);
    }

    @Override
    protected PlayData onNewLoadPlayData() {
        return CodeUtils.oneOf(
                new PlayData(new FacePlay(VideoResource.FESTIVAL_VIDEO_BASE_PATH + "春节美食.mp4", FaceType.Video)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "八宝饭.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "八宝饭.webp", FaceType.Image)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "年糕.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "年糕.webp", FaceType.Image)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "春卷.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "春卷.webp", FaceType.Image)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "春饼.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "春饼.webp", FaceType.Image)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "柿饼.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "柿饼.webp", FaceType.Image)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "汤圆.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "汤圆.webp", FaceType.Image)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "腊味.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "腊味.webp", FaceType.Image)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "饺子.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "饺子.webp", FaceType.Image)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "麻球.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "麻球.webp", FaceType.Image)));
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

