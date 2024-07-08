package com.bearya.robot.fairystory.walk.load.story;

import com.bearya.robot.base.play.FaceType;
import com.bearya.robot.fairystory.ui.res.FileResource;
import com.bearya.robot.fairystory.ui.res.IntroduceTime;
import com.bearya.robot.fairystory.ui.res.MusicResource;
import com.bearya.robot.fairystory.walk.car.LoadMgr;
import com.bearya.robot.fairystory.walk.load.EndLoad;

import java.util.List;
import java.util.Random;

public class MineEndLoad extends EndLoad {

    public static final int START_OID = 10900;//启动点码
    public static final String NAME = "宝藏岛";

    private int endType = -1;

    public MineEndLoad() {
        super(START_OID);
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String[] getEquipmentLoads() {
        return new String[]{
                TreasureMapLoad.NAME, // 藏宝图
                CompassLoad.NAME, // 指南针
                KeyLoad.NAME // 钥匙
        };
    }

    @Override
    public void registerPlay() {
        endType = new Random().nextInt(3000) % 3;
        super.registerPlay();
    }

    @Override
    protected String loadSuccessFacePlay() {
        return endType == 0 ? FileResource.BASE_STORY_ENDING_PATH + "success/seafloor/" :
                endType == 1 ? FileResource.BASE_STORY_ENDING_PATH +  "success/spirit/" :
                        endType == 2 ? FileResource.BASE_STORY_ENDING_PATH +  "success/universe/" : "";
    }

    @Override
    protected String loadFailFacePlay() {
        return endType == 0 ? FileResource.BASE_STORY_ENDING_PATH + "fail/seafloor/" :
                endType == 1 ? FileResource.BASE_STORY_ENDING_PATH +  "fail/spirit/" :
                        endType == 2 ? FileResource.BASE_STORY_ENDING_PATH +  "fail/universe/" : "";
    }

    @Override
    protected int successGapTime() {
        return endType == 0 ? IntroduceTime.seafloorEndTime :
                endType == 1 ? IntroduceTime.spiritEndTime :
                        IntroduceTime.universeEndTime;
    }

    @Override
    protected FaceType defineType() {
        return FaceType.Frame;
    }

    @Override
    protected String playSuccessSound() {
        return endType == 0 ? MusicResource.BASE_ENDING_MUSIC_PATH + "treasure_success2.mp3" :
                endType == 1 ? MusicResource.BASE_ENDING_MUSIC_PATH + "treasure_success3.mp3" :
                        endType == 2 ? MusicResource.BASE_ENDING_MUSIC_PATH + "treasure_success1.mp3" : "";
    }

    @Override
    protected String playFailSound() {
        List<String> lostEquipments = LoadMgr.getInstance().getLostEquipmentLoadList(this);
        if (lostEquipments.size() == 3) {
            return MusicResource.BASE_ENDING_MUSIC_PATH + "treasure_fail7.mp3";
        } else if (lostEquipments.size() == 2) {
            if (!lostEquipments.contains(TreasureMapLoad.NAME)) {
                return MusicResource.BASE_ENDING_MUSIC_PATH + "treasure_fail6.mp3";
            } else if (!lostEquipments.contains(CompassLoad.NAME)) {
                return MusicResource.BASE_ENDING_MUSIC_PATH + "treasure_fail5.mp3";
            } else if (!lostEquipments.contains(KeyLoad.NAME)) {
                return MusicResource.BASE_ENDING_MUSIC_PATH + "treasure_fail4.mp3";
            }
        } else if (lostEquipments.size() == 1) {
            if (KeyLoad.NAME.equals(lostEquipments.get(0))) {
                return MusicResource.BASE_ENDING_MUSIC_PATH + "treasure_fail3.mp3";
            } else if (CompassLoad.NAME.equals(lostEquipments.get(0))) {
                return MusicResource.BASE_ENDING_MUSIC_PATH + "treasure_fail2.mp3";
            } else if (TreasureMapLoad.NAME.equals(lostEquipments.get(0))) {
                return MusicResource.BASE_ENDING_MUSIC_PATH + "treasure_fail1.mp3";
            }
        }
        return "";
    }

    @Override
    protected int failGapTime() {
        return endType == 0 ? IntroduceTime.seafloorFailEndTime :
                endType == 1 ? IntroduceTime.spiritFailEndTime :
                        IntroduceTime.universeFailEndTime;
    }

}