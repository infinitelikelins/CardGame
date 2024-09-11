package com.bearya.robot.fairystory.walk.load.festival;

import com.bearya.robot.base.play.FacePlay;
import com.bearya.robot.base.play.FaceType;
import com.bearya.robot.base.play.PlayData;
import com.bearya.robot.base.util.CodeUtils;
import com.bearya.robot.fairystory.ui.res.MusicResource;
import com.bearya.robot.fairystory.ui.res.PictureResource;
import com.bearya.robot.fairystory.ui.res.VideoResource;
import com.bearya.robot.fairystory.walk.load.EquipmentLoad;

public class SpringKnowledgeLoad extends EquipmentLoad {

    public static final int START_OID = 1900;//启动点码
    public static final String NAME = "春节知多少";

    public SpringKnowledgeLoad() {
        super(START_OID);
    }

    @Override
    protected PlayData onNewLoadPlayData() {
        return CodeUtils.oneOf(
                new PlayData(new FacePlay(VideoResource.FESTIVAL_VIDEO_BASE_PATH + "春节.mp4", FaceType.Video)),
                new PlayData(new FacePlay(VideoResource.FESTIVAL_VIDEO_BASE_PATH + "过年的习俗.mp4", FaceType.Video)),
                new PlayData(new FacePlay(VideoResource.FESTIVAL_VIDEO_BASE_PATH + "年的故事.mp4", FaceType.Video)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "春节习俗.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "春节习俗.webp", FaceType.Image)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "春节由来.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "春节由来.webp", FaceType.Image)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "年的故事.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "年的故事.webp", FaceType.Image)));
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    protected String loadFacePlay() {
        return null;
    }

    @Override
    protected FaceType defineType() {
        return null;
    }

}
