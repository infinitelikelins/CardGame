package com.bearya.robot.fairystory.walk.load.festival;

import com.bearya.robot.base.play.FacePlay;
import com.bearya.robot.base.play.FaceType;
import com.bearya.robot.base.play.PlayData;
import com.bearya.robot.base.util.CodeUtils;
import com.bearya.robot.fairystory.ui.res.MusicResource;
import com.bearya.robot.fairystory.ui.res.PictureResource;
import com.bearya.robot.fairystory.walk.load.EquipmentLoad;

public class LanternFoodsLoad extends EquipmentLoad {

    public static final int START_OID = 6400;//启动点码
    public static final String NAME = "元宵的美食";

    public LanternFoodsLoad() {
        super(START_OID);
    }

    @Override
    protected PlayData onNewLoadPlayData() {
        return CodeUtils.oneOf(
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "吃年糕.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "吃年糕.webp", FaceType.Image)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "捏面灯.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "捏面灯.webp", FaceType.Image)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "枣糕.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "枣糕.webp", FaceType.Image)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "油茶.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "油茶.webp", FaceType.Image))
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
