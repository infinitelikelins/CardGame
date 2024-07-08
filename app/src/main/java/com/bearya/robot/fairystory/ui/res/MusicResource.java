package com.bearya.robot.fairystory.ui.res;

import android.os.Environment;

public interface MusicResource {

    String ROOT = Environment.getExternalStorageDirectory().getPath();

    String BASE_PATH = ROOT + "/fairy/";
    String BASE_MAIN_PATH = ROOT + "/fairy/main/music/";
    String BASE_ENDING_MUSIC_PATH = ROOT + "/fairy/story/ending/music/";
    String BASE_UNIVERSE_THEME_PATH = ROOT + "/fairy/universe/theme/";
    String BASE_STATION_PATH = ROOT + "/fairy/station/";

    String BGM = BASE_MAIN_PATH + "bgm.mp3";
    String TOUCH = BASE_MAIN_PATH + "touch.mp3";
    String WELCOME = BASE_MAIN_PATH + "welcome.mp3";
    String DELAY = BASE_MAIN_PATH + "delay.mp3";
    String THEME = BASE_MAIN_PATH + "theme.mp3";
    String TRAVEL = BASE_MAIN_PATH + "travel_bg.mp3";
    String GOLD_EFFECT = BASE_MAIN_PATH + "gold_effect.mp3";
    String THEME_END_FAIL = BASE_MAIN_PATH + "ThemeEndFail.mp3";

    String DanceStartPlaySound = BASE_PATH + "story/introduce/music/b_back_story.mp3";
    String HeroStartPlaySound = BASE_PATH + "story/introduce/music/h_back_story.mp3";
    String SeafloorStartPlaySound = BASE_PATH + "story/introduce/music/t_back_story.mp3";

}