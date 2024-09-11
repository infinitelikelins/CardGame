package com.bearya.robot.fairystory.walk.load.festival;

import com.bearya.robot.base.play.FacePlay;
import com.bearya.robot.base.play.FaceType;
import com.bearya.robot.base.play.PlayData;
import com.bearya.robot.base.util.CodeUtils;
import com.bearya.robot.fairystory.ui.res.MusicResource;
import com.bearya.robot.fairystory.ui.res.PictureResource;
import com.bearya.robot.fairystory.walk.load.EquipmentLoad;

public class DoubleNinthGameLoad extends EquipmentLoad {

    public static final int START_OID = 21700;//启动点码
    public static final String NAME = "重阳的游戏";

    public DoubleNinthGameLoad() {
        super(START_OID);
    }

    @Override
    protected PlayData onNewLoadPlayData() {
        return CodeUtils.oneOf(
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "按摩放松.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "按摩放松.webp", FaceType.Image)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "洗脚.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "洗脚.webp", FaceType.Image)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "送上礼物.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "送上礼物.webp", FaceType.Image)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "陪伴聊天.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "陪伴聊天.webp", FaceType.Image))
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
