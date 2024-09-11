package com.bearya.robot.fairystory.walk.load.festival;

import com.bearya.robot.base.play.FacePlay;
import com.bearya.robot.base.play.FaceType;
import com.bearya.robot.base.play.PlayData;
import com.bearya.robot.base.util.CodeUtils;
import com.bearya.robot.fairystory.ui.res.MusicResource;
import com.bearya.robot.fairystory.ui.res.PictureResource;
import com.bearya.robot.fairystory.ui.res.VideoResource;
import com.bearya.robot.fairystory.walk.load.EquipmentLoad;

public class DragonBoatCustomLoad extends EquipmentLoad {

    public static final int START_OID = 16300;//启动点码
    public static final String NAME = "端午的习俗";

    public DragonBoatCustomLoad() {
        super(START_OID);
    }

    @Override
    protected PlayData onNewLoadPlayData() {
        return CodeUtils.oneOf(
                new PlayData(new FacePlay(VideoResource.FESTIVAL_VIDEO_BASE_PATH + "端午节习俗.mp4", FaceType.Video)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "吃粽子.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "吃粽子.webp", FaceType.Image)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "戴彩绳.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "戴彩绳.webp", FaceType.Image)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "戴香囊.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "戴香囊.webp", FaceType.Image)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "挂艾草.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "挂艾草.webp", FaceType.Image)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "赛龙舟.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "赛龙舟.webp", FaceType.Image))
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
