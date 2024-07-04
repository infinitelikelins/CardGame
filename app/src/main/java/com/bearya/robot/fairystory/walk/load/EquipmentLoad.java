package com.bearya.robot.fairystory.walk.load;

import com.bearya.robot.base.play.Director;
import com.bearya.robot.base.play.FacePlay;
import com.bearya.robot.base.play.FaceType;
import com.bearya.robot.base.play.LoadPlay;
import com.bearya.robot.base.play.PlayData;
import com.bearya.robot.fairystory.ui.res.MusicResource;
import com.bearya.robot.fairystory.walk.load.lock.DirectorPlayLock;

/**
 * 装备地垫
 */
public abstract class EquipmentLoad extends XLoad {

    public EquipmentLoad(int startOid) {
        super(startOid);
        lock = new DirectorPlayLock();
    }

    @Override
    public void registerPlay() {
        LoadPlay loadPlay = new LoadPlay(new PlayData(playSound(), new FacePlay(loadFacePlay(), defineType(), loadFacePlayTime())));
        Director.getInstance().register(ON_NEW_LOAD, loadPlay);

        LoadPlay failPlay = new LoadPlay(new PlayData(MusicResource.THEME_END_FAIL));
        Director.getInstance().register(ON_END_LOAD_FAIL, failPlay);
    }

    protected abstract String loadFacePlay();

    protected FaceType defineType() {
        return FaceType.Frame;
    }

    protected int loadFacePlayTime() {
        return 0;
    }

    protected String playSound() {
        return null;
    }

}