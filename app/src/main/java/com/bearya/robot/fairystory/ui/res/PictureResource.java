package com.bearya.robot.fairystory.ui.res;

import android.os.Environment;

public interface PictureResource {

    String BASE_PATH = Environment.getExternalStorageDirectory().getPath() + "/fairy/";

    String BASE_STORY_PATH = BASE_PATH + "story/theme/";
    String BASE_UNIVERSE_PATH = BASE_PATH + "universe/theme/";
    String BASE_FESTIVAL_PATH = BASE_PATH + "festival/theme/";
    String BASE_FESTIVAL_EQUIPMENT_PATH = BASE_PATH + "festival/equipment/picture/";

}
