package com.bearya.robot.fairystory.walk.load.story;

import com.bearya.robot.base.card.Additional;
import com.bearya.robot.base.protocol.EquipmentCard;
import com.bearya.robot.fairystory.ui.res.FileResource;
import com.bearya.robot.fairystory.ui.res.IntroduceTime;
import com.bearya.robot.fairystory.ui.res.MusicResource;
import com.bearya.robot.fairystory.walk.load.ObstacleLoad;
import com.bearya.robot.fairystory.walk.load.lock.AdditionalLock;

public class BigMonsterLoad extends ObstacleLoad {

    public static final int START_OID = 43500; // 启动点码
    public static final String NAME = "巨怪地垫";

    public BigMonsterLoad() {
        super(START_OID);
        lock = new AdditionalLock(new Additional(EquipmentCard.PolyJuicePotion));
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    protected String loadFaceSuccessPlay() {
        return FileResource.BASE_PATH + "story/obstacle/success/monster";
    }

    @Override
    protected String loadPlaySuccessSound() {
        return MusicResource.BASE_PATH + "story/obstacle/music/troll_p.mp3";
    }

    @Override
    protected String loadFaceFailPlay() {
        return FileResource.BASE_PATH + "story/obstacle/fail/monster";
    }

    @Override
    protected String loadPlayFailSound() {
        return MusicResource.BASE_PATH + "story/obstacle/music/troll_n.mp3";
    }

    @Override
    protected int loadFacePlayFailTime() {
        return IntroduceTime.monsterFailPlayTime;
    }

    @Override
    protected int loadFacePlaySuccessTime() {
        return IntroduceTime.monsterSuccessPlayTime;
    }

}