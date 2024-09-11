package com.bearya.robot.fairystory.walk.load.festival;

import com.bearya.robot.base.play.FacePlay;
import com.bearya.robot.base.play.FaceType;
import com.bearya.robot.base.play.PlayData;
import com.bearya.robot.base.util.CodeUtils;
import com.bearya.robot.fairystory.ui.res.MusicResource;
import com.bearya.robot.fairystory.ui.res.PictureResource;
import com.bearya.robot.fairystory.ui.res.VideoResource;
import com.bearya.robot.fairystory.walk.load.EquipmentLoad;

public class DragonBoatGardenPartyLoad extends EquipmentLoad {

    public static final int START_OID = 17200;//启动点码
    public static final String NAME = "端午游园会";

    public DragonBoatGardenPartyLoad() {
        super(START_OID);
    }

    @Override
    protected PlayData onNewLoadPlayData() {
        return CodeUtils.oneOf(
                new PlayData(new FacePlay(VideoResource.FESTIVAL_VIDEO_BASE_PATH + "做香囊.mp4", FaceType.Video)),
                new PlayData(new FacePlay(VideoResource.FESTIVAL_VIDEO_BASE_PATH + "套圈圈.mp4", FaceType.Video)),
                new PlayData(new FacePlay(VideoResource.FESTIVAL_VIDEO_BASE_PATH + "射五毒.mp4", FaceType.Video)),
                new PlayData(new FacePlay(VideoResource.FESTIVAL_VIDEO_BASE_PATH + "投壶.mp4", FaceType.Video)),
                new PlayData(new FacePlay(VideoResource.FESTIVAL_VIDEO_BASE_PATH + "蹴鞠.mp4", FaceType.Video)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "做香囊.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "做香囊.webp", FaceType.Image)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "套圈圈.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "套圈圈.webp", FaceType.Image)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "射五毒.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "射五毒.webp", FaceType.Image)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "投壶.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "投壶.webp", FaceType.Image)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "投币祈福.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "投币祈福.webp", FaceType.Image)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "蹴鞠.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "蹴鞠.webp", FaceType.Image))
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
