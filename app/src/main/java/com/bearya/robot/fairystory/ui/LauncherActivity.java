package com.bearya.robot.fairystory.ui;

import android.os.Bundle;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.bearya.robot.base.BaseApplication;
import com.bearya.robot.base.ui.BaseActivity;
import com.bearya.robot.base.util.DeviceUtil;
import com.bearya.robot.base.util.MusicUtil;
import com.bearya.robot.databinding.ActivityLaunchBinding;
import com.bearya.robot.fairystory.ui.adapter.ThemeAdapter;
import com.bearya.robot.fairystory.ui.popup.impl.LottieMotionPopup;
import com.bearya.robot.fairystory.ui.res.MusicResource;
import com.bearya.robot.fairystory.walk.car.LoadMgr;
import com.bearya.robot.fairystory.walk.themes.AbsTheme;
import com.bearya.robot.fairystory.walk.themes.FestivalTheme;
import com.bearya.robot.fairystory.walk.themes.StoryTheme;
import com.bearya.robot.fairystory.walk.themes.UniverseTheme;

/**
 * 启动页面 ， 点点屏幕
 */
public class LauncherActivity extends BaseActivity {

    private boolean fastClick = false;
    private ActivityLaunchBinding bindView;
    private ThemeAdapter themeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindView = ActivityLaunchBinding.inflate(getLayoutInflater());
        setContentView(bindView.getRoot());

        bindView.theme.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        themeAdapter = new ThemeAdapter();

        themeAdapter.addData(new StoryTheme());
        themeAdapter.addData(new UniverseTheme());
        themeAdapter.addData(new FestivalTheme());

        bindView.theme.setAdapter(themeAdapter);

        themeAdapter.setOnItemClickListener((adapter, view, position) -> {
            if (fastClick)
                return;
            AbsTheme item = themeAdapter.getItem(position);
            if (item != null) {
                fastClick = true;
                LoadMgr.getInstance().setTheme(item);
                MusicUtil.playMusic(item.themeNameSound(), v -> ThemesActivity.start(this));
            } else {
                Toast.makeText(this, "主题加载异常啦！！！", Toast.LENGTH_SHORT).show();
            }
        });

        bindView.tvVersion.setText(String.format("版本号: %s", DeviceUtil.getVersionName(getApplicationContext())));

        bindView.btnBack.setOnClickListener(v -> BaseApplication.getInstance().release());

        bindView.lottieMotion.setOnClickListener(v -> new LottieMotionPopup(LauncherActivity.this).showPopupWindow());

    }

    @Override
    protected void onResume() {
        super.onResume();
        MusicUtil.playMusic(MusicResource.TOUCH, mp -> MusicUtil.playBGM(MusicResource.BGM));
        fastClick = false;
        LoadMgr.getInstance().release();
    }

}