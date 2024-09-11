package com.bearya.robot.fairystory.walk.load.festival;

import com.bearya.robot.base.play.FacePlay;
import com.bearya.robot.base.play.FaceType;
import com.bearya.robot.base.play.PlayData;
import com.bearya.robot.base.util.CodeUtils;
import com.bearya.robot.fairystory.ui.res.MusicResource;
import com.bearya.robot.fairystory.ui.res.PictureResource;
import com.bearya.robot.fairystory.walk.load.EquipmentLoad;

public class WinterCustomLoad extends EquipmentLoad {

    public static final int START_OID = 33600;//启动点码
    public static final String NAME = "冬至的习俗";

    public WinterCustomLoad() {
        super(START_OID);
    }

    @Override
    protected PlayData onNewLoadPlayData() {
        return CodeUtils.oneOf(
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "吃汤圆.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "吃汤圆.webp", FaceType.Image)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "吃羊肉汤.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "吃羊肉汤.webp", FaceType.Image)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "吃饺子.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "吃饺子.webp", FaceType.Image)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "画九.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "画九.webp", FaceType.Image)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "酿米酒.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "酿米酒.webp", FaceType.Image))
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
