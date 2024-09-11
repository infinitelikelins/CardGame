package com.bearya.robot.fairystory.walk.load.festival;

import com.bearya.robot.base.play.FacePlay;
import com.bearya.robot.base.play.FaceType;
import com.bearya.robot.base.play.PlayData;
import com.bearya.robot.base.util.CodeUtils;
import com.bearya.robot.fairystory.ui.res.MusicResource;
import com.bearya.robot.fairystory.ui.res.PictureResource;
import com.bearya.robot.fairystory.ui.res.VideoResource;
import com.bearya.robot.fairystory.walk.load.EquipmentLoad;

public class SpringDragonLoad extends EquipmentLoad {

    public static final int START_OID = 3700;//启动点码
    public static final String NAME = "寻龙记";

    public SpringDragonLoad() {
        super(START_OID);
    }

    @Override
    protected PlayData onNewLoadPlayData() {
        return CodeUtils.oneOf(
                new PlayData(new FacePlay(VideoResource.FESTIVAL_VIDEO_BASE_PATH + "龙的九子介绍.mp4", FaceType.Video)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "嘲风.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "嘲风.webp", FaceType.Image)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "囚牛.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "囚牛.webp", FaceType.Image)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "狴犴.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "狴犴.webp", FaceType.Image)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "狻猊.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "狻猊.webp", FaceType.Image)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "睚眦.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "睚眦.webp", FaceType.Image)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "蒲牢.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "蒲牢.webp", FaceType.Image)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "螭吻.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "螭吻.webp", FaceType.Image)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "负屃.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "负屃.webp", FaceType.Image)),
                new PlayData(MusicResource.BASE_FESTIVAL_EQUIPMENT_PATH + "霸下.mp3", new FacePlay(PictureResource.BASE_FESTIVAL_EQUIPMENT_PATH + "霸下.webp", FaceType.Image))
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

