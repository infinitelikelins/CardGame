package com.bearya.robot.fairystory.ui.res;

import android.os.Environment;

public interface FileResource {

    String ROOT = Environment.getExternalStorageDirectory().getPath();

    String BASE_PATH = ROOT + "/fairy/";

    String BASE_STORY_ENDING_PATH = ROOT + "/fairy/story/ending/";

}