package com.bearya.robot.fairystory.walk.load;

import com.bearya.robot.base.play.Director;
import com.bearya.robot.base.play.FacePlay;
import com.bearya.robot.base.play.FaceType;
import com.bearya.robot.base.play.LoadPlay;
import com.bearya.robot.base.play.PlayData;
import com.bearya.robot.fairystory.walk.load.lock.DirectorPlayLock;

/**
 * 障碍地垫
 */
public abstract class NoEntryLoad extends XLoad {

    public NoEntryLoad(int startOid) {
        super(startOid);
        lock = new DirectorPlayLock();
    }

    @Override
    public void registerPlay() {
        LoadPlay unlockSuccessPlay = new LoadPlay();
        unlockSuccessPlay.addLoad(new PlayData(loadPlaySound(), new FacePlay(loadFacePlay(), FaceType.Frame, loadPlayFaceTime(), false)));
        Director.getInstance().register(ON_NEW_LOAD, unlockSuccessPlay);

        Director.getInstance().register(ON_END_LOAD_FAIL, new LoadPlay());
    }

    /**
     * 加载的动画文件路径
     */
    protected abstract String loadFacePlay();

    /**
     * 播放音频
     */
    protected abstract String loadPlaySound();

    /**
     * 播放时间间隔
     */
    protected abstract int loadPlayFaceTime();

}