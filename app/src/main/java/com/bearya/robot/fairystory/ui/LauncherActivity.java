package com.bearya.robot.fairystory.ui;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.bearya.robot.base.BaseApplication;
import com.bearya.robot.base.ui.BaseActivity;
import com.bearya.robot.base.util.DebugUtil;
import com.bearya.robot.base.util.DeviceUtil;
import com.bearya.robot.base.util.FileUtil;
import com.bearya.robot.base.util.MusicUtil;
import com.bearya.robot.databinding.ActivityLaunchBinding;
import com.bearya.robot.fairystory.ui.adapter.ThemeAdapter;
import com.bearya.robot.fairystory.ui.res.FileResource;
import com.bearya.robot.fairystory.ui.res.MusicResource;
import com.bearya.robot.fairystory.walk.car.LoadMgr;
import com.bearya.robot.fairystory.walk.themes.AbsTheme;
import com.bearya.robot.fairystory.walk.themes.FestivalTheme;
import com.bearya.robot.fairystory.walk.themes.StoryTheme;
import com.bearya.robot.fairystory.walk.themes.UniverseTheme;

import java.io.IOException;
import java.util.Objects;

/**
 * 启动页面 ， 点点屏幕
 */
public class LauncherActivity extends BaseActivity {

    private ActivityLaunchBinding bindView;
    private ThemeAdapter themeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindView = ActivityLaunchBinding.inflate(getLayoutInflater());
        setContentView(bindView.getRoot());

        bindView.theme.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        themeAdapter = new ThemeAdapter();

        try {
            String theme = FileUtil.stringFromSDCard(FileResource.themeConfigPath);
            if (theme.contains(StoryTheme.KEY)) {
                themeAdapter.addData(new StoryTheme());
            }
            if (theme.contains(UniverseTheme.KEY)) {
                themeAdapter.addData(new UniverseTheme());
            }
            if (theme.contains(FestivalTheme.KEY)) {
                themeAdapter.addData(new FestivalTheme());
            }
        } catch (IOException e) {
            DebugUtil.debug(e.getMessage());
        }

        bindView.theme.setAdapter(themeAdapter);

        themeAdapter.setOnItemClickListener((adapter, view, position) -> {
            AbsTheme item = Objects.requireNonNull(themeAdapter.getItem(position));
            LoadMgr.getInstance().setTheme(item);
            MusicUtil.playMusic(item.themeNameSound(), v -> ThemesActivity.start(this));
        });

        bindView.tvVersion.setText(String.format("版本号: %s", DeviceUtil.getVersionName(getApplicationContext())));

        bindView.btnBack.setOnClickListener(v -> BaseApplication.getInstance().release());

    }

    @Override
    protected void onResume() {
        super.onResume();
        MusicUtil.playMusic(MusicResource.TOUCH, mp -> MusicUtil.playBGM(MusicResource.BGM));
    }

}