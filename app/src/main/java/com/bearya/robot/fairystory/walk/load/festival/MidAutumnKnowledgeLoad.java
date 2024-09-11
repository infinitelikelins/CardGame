package com.bearya.robot.fairystory.walk.load.festival;

import com.bearya.robot.base.play.FacePlay;
import com.bearya.robot.base.play.FaceType;
import com.bearya.robot.base.play.PlayData;
import com.bearya.robot.base.util.CodeUtils;
import com.bearya.robot.fairystory.ui.res.MusicResource;
import com.bearya.robot.fairystory.ui.res.PictureResource;
import com.bearya.robot.fairystory.ui.res.VideoResource;
import com.bearya.robot.fairystory.walk.load.EquipmentLoad;

public class MidAutumnKnowledgeLoad extends EquipmentLoad {

    public static final int START_OID = 23500;//启动点码
    public static final String NAME = "中秋知多少";

    public MidAutumnKnowledgeLoad() {
        super(START_OID);
    }

    @Override
    protected PlayData onNewLoadPlayData() {
        return CodeUtils.oneOf(
                new PlayData(new FacePlay(VideoResource.FESTIVAL_VIDEO_BASE_PATH + "中秋的由来.mp4", FaceType.Video)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "吴刚伐桂.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "吴刚伐桂.webp", FaceType.Image)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "嫦娥奔月.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "嫦娥奔月.webp", FaceType.Image)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "玉兔捣药.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "玉兔捣药.webp", FaceType.Image))
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
