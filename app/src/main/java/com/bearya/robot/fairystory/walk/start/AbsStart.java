package com.bearya.robot.fairystory.walk.start;

import com.bearya.robot.base.play.FaceType;

/**
 * 场景 开始 故事简述
 */
public interface AbsStart {

    String playSound();

    String facePath();

    FaceType defineType();

    int gapTime();

    String travelReady();

}
