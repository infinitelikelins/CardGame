package com.bearya.robot.fairystory.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.bearya.robot.R;
import com.bearya.robot.base.ui.BaseActivity;
import com.bearya.robot.base.ui.view.FrameSurfaceView;
import com.bearya.robot.base.util.MusicUtil;
import com.bearya.robot.databinding.ActivityThemeIntroduceBinding;
import com.bearya.robot.fairystory.ui.stage.FrameFragment;
import com.bearya.robot.fairystory.ui.stage.PictureFragment;
import com.bearya.robot.fairystory.ui.stage.VideoFragment;
import com.bearya.robot.fairystory.walk.car.LoadMgr;
import com.bearya.robot.fairystory.walk.start.AbsStart;

/**
 * 场景动画 起始背景介绍
 */
public class ThemeIntroduceActivity extends BaseActivity {

    private ActivityThemeIntroduceBinding bindView;

    public static void start(Context context) {
        context.startActivity(new Intent(context, ThemeIntroduceActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindView = ActivityThemeIntroduceBinding.inflate(getLayoutInflater());
        setContentView(bindView.getRoot());

        AbsStart start = LoadMgr.getInstance().getCurrentSubject().start();

        Fragment fragment = replaceScreen(start);

        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_introduce, fragment)
                    .commitNowAllowingStateLoss();
        } else {
            CardControllerActivity.start(ThemeIntroduceActivity.this, null);
            finish();
        }

        // 跳过场景介绍动画
        withClick(bindView.fragmentIntroduce, view -> {
            CardControllerActivity.start(ThemeIntroduceActivity.this, null);
            finish();
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        MusicUtil.stopMusic();
    }

    private Fragment replaceScreen(AbsStart start) {
        switch (start.defineType()) {
            case Image:
                // 音频的播放事件
                MusicUtil.playMusic(start.playSound(), mediaPlayer -> {
                    CardControllerActivity.start(ThemeIntroduceActivity.this, null);
                    finish();
                });
                return PictureFragment.newInstance(start.facePath());
            case Frame:
                FrameFragment frameFragment = FrameFragment.newInstance(start.facePath(), start.gapTime() , false);
                frameFragment.setOnFrameFinishedListener(new FrameSurfaceView.OnFrameFinishedListener() {
                    private boolean isMusicFinishedFlag = false;
                    private boolean isFrameFinishedFlag = false;

                    @Override
                    public void onFrameStart() {
                        MusicUtil.playMusic(start.playSound(), mediaPlayer -> {
                            isMusicFinishedFlag = true;
                            if (isFrameFinishedFlag) {
                                CardControllerActivity.start(ThemeIntroduceActivity.this, null);
                                finish();
                            }
                        });
                    }

                    @Override
                    public void onFrameFinish() {
                        isFrameFinishedFlag = true;
                        if (isMusicFinishedFlag) {
                            CardControllerActivity.start(ThemeIntroduceActivity.this, null);
                            finish();
                        }
                    }
                });
                return frameFragment;
            case Video:
                VideoFragment videoFragment = VideoFragment.newInstance(start.facePath());
                videoFragment.setOnVideoCompletedListener(mp -> {
                    CardControllerActivity.start(ThemeIntroduceActivity.this, null);
                    finish();
                });
                return videoFragment;
            default:
                return null;
        }
    }

}