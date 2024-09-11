package com.bearya.robot.fairystory.ui.res;

import android.os.Environment;

public interface PictureResource {
    String ROOT = Environment.getExternalStorageDirectory().getPath();

    String BASE_PATH = ROOT + "/fairy/";
    String BASE_STORY_PATH = ROOT + "/fairy/story/theme/";
    String BASE_UNIVERSE_PATH = ROOT + "/fairy/universe/theme/";
    String BASE_FESTIVAL_PATH = ROOT + "/fairy/festival/theme/";
    String BASE_FESTIVAL_EQUIPMENT_PATH = ROOT + "/fairy/festival/equipment/picture/";
}
