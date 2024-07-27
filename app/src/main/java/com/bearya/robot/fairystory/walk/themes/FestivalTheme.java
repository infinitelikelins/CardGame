package com.bearya.robot.fairystory.walk.themes;

import com.bearya.robot.R;
import com.bearya.robot.base.load.BaseLoad;
import com.bearya.robot.fairystory.walk.subjects.AbsSubject;

import java.util.Collections;
import java.util.Map;

public class FestivalTheme implements AbsTheme {
    public static final String FESTIVAL = "Festival";

    @Override
    public String theme() {
        return FESTIVAL;
    }

    @Override
    public int res() {
        return R.mipmap.theme_festival;
    }

    @Override
    public AbsSubject[] subjects() {
        return new AbsSubject[]{

        };
    }

    @Override
    public Map<String, BaseLoad> loads() {
        return Collections.emptyMap();
    }

    @Override
    public AbsSubject dreamSubject() {
        return null;
    }

    @Override
    public int backgroundPath() {
        return 0;
    }

    @Override
    public int stationEnterImage() {
        return 0;
    }

}
