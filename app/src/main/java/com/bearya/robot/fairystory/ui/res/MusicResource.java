package com.bearya.robot.fairystory.ui.res;

import android.os.Environment;

public interface MusicResource {

    String BASE_PATH = Environment.getExternalStorageDirectory().getPath() + "/fairy/";
    String BASE_ENDING_MUSIC_PATH = Environment.getExternalStorageDirectory().getPath() + "/fairy/story/ending/music/";
    String BASE_UNIVERSE_THEME_PATH = Environment.getExternalStorageDirectory().getPath() + "/fairy/universe/theme/";

    String BGM = BASE_PATH + "main/music/bgm.mp3";
    String TOUCH = BASE_PATH + "main/music/touch.mp3";
    String WELCOME = BASE_PATH + "main/music/welcome.mp3";
    String DELAY = BASE_PATH + "main/music/delay.mp3";
    String THEME = BASE_PATH + "main/music/theme.mp3";
    String TRAVEL = BASE_PATH + "main/music/travel_bg.mp3";

    String GOLD_EFFECT = BASE_PATH + "main/music/gold_effect.mp3";
    String THEME_END_FAIL = BASE_UNIVERSE_THEME_PATH + "ThemeEndFail.mp3";

    String DanceStartPlaySound = BASE_PATH + "story/introduce/music/b_back_story.mp3";
    String HeroStartPlaySound = BASE_PATH + "story/introduce/music/h_back_story.mp3";
    String SeafloorStartPlaySound = BASE_PATH + "story/introduce/music/t_back_story.mp3";

}