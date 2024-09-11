package com.bearya.robot.fairystory.walk.load.festival;

import com.bearya.robot.base.play.FacePlay;
import com.bearya.robot.base.play.FaceType;
import com.bearya.robot.base.play.PlayData;
import com.bearya.robot.base.util.CodeUtils;
import com.bearya.robot.fairystory.ui.res.MusicResource;
import com.bearya.robot.fairystory.ui.res.PictureResource;
import com.bearya.robot.fairystory.ui.res.VideoResource;
import com.bearya.robot.fairystory.walk.load.EquipmentLoad;

public class MidAutumnGardenPartyLoad extends EquipmentLoad {

    public static final int START_OID = 30900;//启动点码
    public static final String NAME = "中秋游园会";

    public MidAutumnGardenPartyLoad() {
        super(START_OID);
    }

    @Override
    protected PlayData onNewLoadPlayData() {
        return CodeUtils.oneOf(
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "博饼.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "博饼.webp", FaceType.Image)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "后羿射日.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "后羿射日.webp", FaceType.Image)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "品月饼.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "品月饼.webp", FaceType.Image)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "近水楼台先得月.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "近水楼台先得月.webp", FaceType.Image))
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