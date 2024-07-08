package com.bearya.robot.fairystory.ui.res;

import android.os.Environment;

public interface PictureResource {
    String ROOT = Environment.getExternalStorageDirectory().getPath();

    String BASE_PATH = ROOT + "/fairy/";
    String BASE_UNIVERSE_PATH = ROOT + "/fairy/universe/theme/";
}
