package com.bearya.robot.fairystory.walk.themes;

import com.bearya.robot.base.load.BaseLoad;
import com.bearya.robot.fairystory.walk.subjects.AbsSubject;

import java.util.Map;

public interface AbsTheme {

    String theme();

    int res();

    AbsSubject[] subjects();

    Map<String , BaseLoad> loads();

    AbsSubject dreamSubject();

    int backgroundPath();

    int stationEnterImage();

}
