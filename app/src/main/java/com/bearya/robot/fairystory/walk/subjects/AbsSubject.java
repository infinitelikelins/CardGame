package com.bearya.robot.fairystory.walk.subjects;

import com.bearya.actionlib.utils.KVManager;
import com.bearya.robot.fairystory.walk.load.EndLoad;
import com.bearya.robot.fairystory.walk.start.AbsStart;

/**
 * 游戏 正式 主题 （对应开始和终点）
 */
public abstract class AbsSubject {

    public abstract String name();

    public abstract String type();

    public abstract String tabImage();

    public abstract String travel();

    public abstract AbsStart start();

    public abstract EndLoad end();

    public boolean mute() {
        return KVManager.getInstance().getBoolean("mute_" + type());
    }

    public void muteChange() {
        KVManager.getInstance().put("mute_" + type(), !mute());
    }

}
