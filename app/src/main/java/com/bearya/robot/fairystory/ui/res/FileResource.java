package com.bearya.robot.fairystory.ui.res;

import android.os.Environment;

public interface FileResource {

    String BASE_PATH = Environment.getExternalStorageDirectory().getPath() + "/fairy/";

    String BASE_STORY_ENDING_PATH = Environment.getExternalStorageDirectory().getPath() + "/fairy/story/ending/";

}