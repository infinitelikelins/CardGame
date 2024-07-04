package com.bearya.robot.fairystory.walk.load;

import com.bearya.robot.base.play.Director;
import com.bearya.robot.base.play.FacePlay;
import com.bearya.robot.base.play.FaceType;
import com.bearya.robot.base.play.LoadPlay;
import com.bearya.robot.base.play.PlayData;
import com.bearya.robot.fairystory.walk.load.lock.DirectorPlayLock;

public abstract class EndLoad extends XLoad {

    public EndLoad(int startOid) {
        super(startOid);
        lock = new DirectorPlayLock();
    }

    @Override
    public void registerPlay() {
        LoadPlay unlockSuccessPlay = new LoadPlay();
        Director.getInstance().register(ON_NEW_LOAD, unlockSuccessPlay);

        LoadPlay successPlay = new LoadPlay(new PlayData(playSuccessSound(), new FacePlay(loadSuccessFacePlay(), defineType(), successGapTime())));
        Director.getInstance().register(ON_END_LOAD_SUCCESS, successPlay);

        LoadPlay failPlay = new LoadPlay(new PlayData(playFailSound(), new FacePlay(loadFailFacePlay(), defineType(), failGapTime())));
        Director.getInstance().register(ON_END_LOAD_FAIL, failPlay);
    }

    /**
     * 到达终点所需要的装备
     */
    public abstract String[] getEquipmentLoads();

    protected abstract String loadSuccessFacePlay();

    protected abstract String loadFailFacePlay();

    protected abstract int successGapTime();

    protected abstract FaceType defineType();

    protected abstract String playSuccessSound();

    protected abstract String playFailSound();

    protected abstract int failGapTime();
}