package com.bearya.robot.fairystory;

import com.bearya.robot.base.BaseApplication;
import com.bearya.robot.base.util.DebugUtil;

public class FairyStoryApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        DebugUtil.setDebugMode(true);
    }

}