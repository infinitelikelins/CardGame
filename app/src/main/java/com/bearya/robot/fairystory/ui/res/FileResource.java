package com.bearya.robot.fairystory.ui.res;

import android.os.Environment;

public interface FileResource {

    String BASE_PATH = Environment.getExternalStorageDirectory().getPath() + "/fairy/";

    String BASE_STORY_ENDING_PATH = BASE_PATH + "story/ending/";
    String themeConfigPath = BASE_PATH + "main/launcher/theme.txt";

    String BASE_EMOTION_CHENG = BASE_PATH + "main/emotion/cheng_jing_gu";
    String BASE_EMOTION_SHE = BASE_PATH + "main/emotion/she_jing";

}