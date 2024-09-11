package com.bearya.robot.fairystory.walk.load.festival;

import com.bearya.robot.base.play.FacePlay;
import com.bearya.robot.base.play.FaceType;
import com.bearya.robot.base.play.PlayData;
import com.bearya.robot.base.util.CodeUtils;
import com.bearya.robot.fairystory.ui.res.MusicResource;
import com.bearya.robot.fairystory.ui.res.PictureResource;
import com.bearya.robot.fairystory.ui.res.VideoResource;
import com.bearya.robot.fairystory.walk.load.EquipmentLoad;

public class MidAutumnCustomLoad extends EquipmentLoad {

    public static final int START_OID = 24400;//启动点码
    public static final String NAME = "中秋的习俗";

    public MidAutumnCustomLoad() {
        super(START_OID);
    }

    @Override
    protected PlayData onNewLoadPlayData() {
        return CodeUtils.oneOf(
                new PlayData(new FacePlay(VideoResource.FESTIVAL_VIDEO_BASE_PATH + "赏月.mp4", FaceType.Video)),
                new PlayData(new FacePlay(VideoResource.FESTIVAL_VIDEO_BASE_PATH + "赏花灯.mp4", FaceType.Video)),
                new PlayData(new FacePlay(VideoResource.FESTIVAL_VIDEO_BASE_PATH + "饮桂花酒.mp4", FaceType.Video))
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