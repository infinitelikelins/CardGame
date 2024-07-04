package com.bearya.robot.fairystory.walk.load.story;

import com.bearya.robot.base.play.FaceType;
import com.bearya.robot.fairystory.ui.res.FileResource;
import com.bearya.robot.fairystory.ui.res.IntroduceTime;
import com.bearya.robot.fairystory.ui.res.MusicResource;
import com.bearya.robot.fairystory.walk.car.LoadMgr;
import com.bearya.robot.fairystory.walk.load.EndLoad;

import java.util.List;

public class DragonEndLoad extends EndLoad {
    public static final int START_OID = 57000;//启动点码
    public static final String NAME = "恶龙谷";

    public DragonEndLoad() {
        super(START_OID);
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String[] getEquipmentLoads() {
        return new String[]{
                ArmorLoad.NAME, // 铠甲
                PegasusLoad.NAME, // 飞马
                SwordLoad.NAME // 宝剑
        };
    }

    @Override
    protected String loadSuccessFacePlay() {
        return FileResource.BASE_STORY_ENDING_PATH + "success/hero";
    }

    @Override
    protected String loadFailFacePlay() {
        return FileResource.BASE_STORY_ENDING_PATH + "fail/hero";
    }

    @Override
    protected int successGapTime() {
        return IntroduceTime.heroEndTime;
    }

    @Override
    protected FaceType defineType() {
        return FaceType.Frame;
    }

    @Override
    protected String playSuccessSound() {
        return MusicResource.BASE_ENDING_MUSIC_PATH + "hero_success1.mp3";
    }

    @Override
    protected String playFailSound() {
        List<String> lostEquipments = LoadMgr.getInstance().getLostEquipmentLoads();
        switch (lostEquipments.size()) {
            case 3:
                return MusicResource.BASE_ENDING_MUSIC_PATH + "hero_fail7.mp3";
            case 2:
                if (!lostEquipments.contains(PegasusLoad.NAME)) {
                    return MusicResource.BASE_ENDING_MUSIC_PATH + "hero_fail6.mp3";
                } else if (!lostEquipments.contains(SwordLoad.NAME)) {
                    return MusicResource.BASE_ENDING_MUSIC_PATH + "hero_fail5.mp3";
                } else if (!lostEquipments.contains(ArmorLoad.NAME)) {
                    return MusicResource.BASE_ENDING_MUSIC_PATH + "hero_fail4.mp3";
                }
                break;
            case 1:
                if (ArmorLoad.NAME.equals(lostEquipments.get(0))) {
                    return MusicResource.BASE_ENDING_MUSIC_PATH + "hero_fail3.mp3";
                } else if (SwordLoad.NAME.equals(lostEquipments.get(0))) {
                    return MusicResource.BASE_ENDING_MUSIC_PATH + "hero_fail2.mp3";
                } else if (PegasusLoad.NAME.equals(lostEquipments.get(0))) {
                    return MusicResource.BASE_ENDING_MUSIC_PATH + "hero_fail1.mp3";
                }
                break;
        }
        return "";
    }

    @Override
    protected int failGapTime() {
        return IntroduceTime.heroFailEndTime;
    }

}