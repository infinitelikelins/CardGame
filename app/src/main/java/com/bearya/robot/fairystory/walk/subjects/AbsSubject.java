package com.bearya.robot.fairystory.walk.subjects;

import com.bearya.robot.fairystory.walk.load.EndLoad;
import com.bearya.robot.fairystory.walk.start.AbsStart;

/**
 * 游戏 正式 主题 （对应开始和终点）
 */
public interface AbsSubject {

    String name();

    String type();

    int res();

    String travel();

    AbsStart start();

    EndLoad end();

}
