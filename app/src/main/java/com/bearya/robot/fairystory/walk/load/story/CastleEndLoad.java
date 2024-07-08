package com.bearya.robot.fairystory.walk.load.story;

import com.bearya.robot.base.play.FaceType;
import com.bearya.robot.fairystory.ui.res.FileResource;
import com.bearya.robot.fairystory.ui.res.IntroduceTime;
import com.bearya.robot.fairystory.ui.res.MusicResource;
import com.bearya.robot.fairystory.walk.car.LoadMgr;
import com.bearya.robot.fairystory.walk.load.EndLoad;

import java.util.List;

public class CastleEndLoad extends EndLoad {

    public static final int START_OID = 57900;//启动点码

    public static final String NAME = "梦幻城堡";

    public CastleEndLoad() {
        super(START_OID);
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String[] getEquipmentLoads() {
        return new String[]{
                CrystalShoesLoad.NAME, // 水晶鞋
                DanceSkirtLoad.NAME, // 跳舞裙
                FatTonnyLoad.NAME // 南瓜车
        };
    }

    @Override
    protected String loadSuccessFacePlay() {
        return FileResource.BASE_STORY_ENDING_PATH + "success/dance";
    }

    @Override
    protected String loadFailFacePlay() {
        return FileResource.BASE_STORY_ENDING_PATH + "fail/dance";
    }

    @Override
    protected int successGapTime() {
        return IntroduceTime.ballEndTime;
    }

    @Override
    protected FaceType defineType() {
        return FaceType.Frame;
    }

    @Override
    protected String playSuccessSound() {
        return MusicResource.BASE_ENDING_MUSIC_PATH + "ball_success1.mp3";
    }

    @Override
    protected String playFailSound() {
        List<String> lostEquipments = LoadMgr.getInstance().getLostEquipmentLoadList(this);
        switch (lostEquipments.size()) {
            case 3:
                return MusicResource.BASE_ENDING_MUSIC_PATH +"ball_fail7.mp3";
            case 2:
                if (!lostEquipments.contains(DanceSkirtLoad.NAME)) {
                    return MusicResource.BASE_ENDING_MUSIC_PATH + "ball_fail6.mp3";
                } else if (!lostEquipments.contains(CrystalShoesLoad.NAME)) {
                    return MusicResource.BASE_ENDING_MUSIC_PATH + "ball_fail5.mp3";
                } else if (!lostEquipments.contains(FatTonnyLoad.NAME)) {
                    return MusicResource.BASE_ENDING_MUSIC_PATH + "ball_fail4.mp3";
                }
                break;
            case 1:
                if (FatTonnyLoad.NAME.equals(lostEquipments.get(0))) {
                    return MusicResource.BASE_ENDING_MUSIC_PATH + "ball_fail3.mp3";
                } else if (CrystalShoesLoad.NAME.equals(lostEquipments.get(0))) {
                    return MusicResource.BASE_ENDING_MUSIC_PATH + "ball_fail2.mp3";
                } else if (DanceSkirtLoad.NAME.equals(lostEquipments.get(0))) {
                    return MusicResource.BASE_ENDING_MUSIC_PATH + "ball_fail1.mp3";
                }
                break;
        }
        return "";
    }

    @Override
    protected int failGapTime() {
        return IntroduceTime.ballFailEndTime;
    }

}