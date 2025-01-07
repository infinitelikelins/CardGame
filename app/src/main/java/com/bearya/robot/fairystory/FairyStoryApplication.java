package com.bearya.robot.fairystory;

import com.bearya.robot.base.BaseApplication;
import com.bearya.robot.base.util.DebugUtil;
import com.bearya.robot.fairystory.walk.car.LoadMgr;

public class FairyStoryApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        DebugUtil.setDebugMode(false);
    }

    @Override
    public void release() {
        super.release();
        LoadMgr.getInstance().release();
    }

}