package com.bearya.robot.fairystory.walk.themes;

import com.bearya.robot.base.load.BaseLoad;
import com.bearya.robot.fairystory.walk.subjects.AbsSubject;

import java.util.Map;

public abstract class AbsTheme {

    public abstract String theme();

    public abstract int res();

    public abstract AbsSubject[] subjects();

    public abstract Map<String, BaseLoad> loads();

    public abstract AbsSubject dreamSubject();

    public abstract int backgroundPath();

    public abstract int stationEnterImage();

    public abstract String welcomeSound();

    public abstract String themeNameSound();

}