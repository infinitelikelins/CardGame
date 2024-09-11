package com.bearya.robot.fairystory.walk.load.festival;

import com.bearya.robot.base.play.FacePlay;
import com.bearya.robot.base.play.FaceType;
import com.bearya.robot.base.play.PlayData;
import com.bearya.robot.base.util.CodeUtils;
import com.bearya.robot.fairystory.ui.res.MusicResource;
import com.bearya.robot.fairystory.ui.res.PictureResource;
import com.bearya.robot.fairystory.ui.res.VideoResource;
import com.bearya.robot.fairystory.walk.load.EquipmentLoad;

public class TombSweepCustomLoad extends EquipmentLoad {

    public static final int START_OID = 10000;//启动点码
    public static final String NAME = "清明的习俗";

    public TombSweepCustomLoad() {
        super(START_OID);
    }

    @Override
    protected PlayData onNewLoadPlayData() {
        return CodeUtils.oneOf(
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "扫墓.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "扫墓.webp", FaceType.Image)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "插柳.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "插柳.webp", FaceType.Image)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "植树.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "植树.webp", FaceType.Image)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "踏青.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "踏青.webp", FaceType.Image))
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

