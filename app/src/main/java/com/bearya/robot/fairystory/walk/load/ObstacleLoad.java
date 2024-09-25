package com.bearya.robot.fairystory.walk.load;

import com.bearya.robot.base.play.Director;
import com.bearya.robot.base.play.FacePlay;
import com.bearya.robot.base.play.FaceType;
import com.bearya.robot.base.play.LoadPlay;
import com.bearya.robot.base.play.PlayData;
import com.bearya.robot.fairystory.ui.res.IntroduceTime;

/**
 * 障碍地垫
 */
public abstract class ObstacleLoad extends XLoad {

    public ObstacleLoad(int startOid) {
        super(startOid);
    }

    @Override
    public void registerPlay() {
        registerUnlockSuccessPlay();
        registerUnlockFailPlay();
    }

    /**
     * 添加解锁正反馈
     */
    private void registerUnlockSuccessPlay() {
        LoadPlay unlockSuccessPlay = new LoadPlay();
        PlayData playData = new PlayData();
        playData.facePlay = new FacePlay(loadFaceSuccessPlay(), FaceType.Frame, loadFacePlaySuccessTime(), false);
        playData.sound = loadPlaySuccessSound();
        unlockSuccessPlay.addLoad(playData);
        Director.getInstance().register(ON_UNLOCK_SUCCESS, unlockSuccessPlay);
    }

    /**
     * 添加解锁负反馈
     */
    private void registerUnlockFailPlay() {
        LoadPlay unlockFailPlay = new LoadPlay();
        PlayData playData = new PlayData();
        playData.facePlay = new FacePlay(loadFaceFailPlay(), FaceType.Frame, loadFacePlayFailTime() ,false);
        playData.sound = loadPlayFailSound();
        unlockFailPlay.addLoad(playData);
        Director.getInstance().register(ON_UNLOCK_FAIL, unlockFailPlay);
    }

    /**
     * 道具卡匹配的动画文件数组路径
     */
    protected abstract String loadFaceSuccessPlay();

    /**
     * 道具卡匹配的动画配音
     */
    protected abstract String loadPlaySuccessSound();

    /**
     * 道具卡不匹配的动画文件数组路径
     */
    protected abstract String loadFaceFailPlay();

    /**
     * 道具卡不匹配的动画配音
     */
    protected abstract String loadPlayFailSound();

    /**
     * 道具卡匹配的动画单帧动画时间的间隔
     */
    protected int loadFacePlaySuccessTime() {
        return IntroduceTime.def;
    }

    /**
     * 道具卡不匹配的动画单帧动画时间的间隔
     */
    protected int loadFacePlayFailTime() {
        return IntroduceTime.def;
    }

}