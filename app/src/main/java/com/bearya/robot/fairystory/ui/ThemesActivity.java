package com.bearya.robot.fairystory.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.bearya.robot.base.ui.BaseActivity;
import com.bearya.robot.base.util.MusicUtil;
import com.bearya.robot.databinding.ActivityThemesBinding;
import com.bearya.robot.fairystory.ui.adapter.SubjectsAdapter;
import com.bearya.robot.fairystory.ui.res.MusicResource;
import com.bearya.robot.fairystory.walk.car.LoadMgr;

import java.util.concurrent.TimeUnit;

/**
 * 主题乐园,在这里可以选择不同的关卡进行游戏
 */
public class ThemesActivity extends BaseActivity implements View.OnClickListener {

    private ActivityThemesBinding bindView;
    private rx.Subscription subscribe;
    private boolean singleClickLock = false;

    public static void start(Context context) {
        context.startActivity(new Intent(context, ThemesActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindView = ActivityThemesBinding.inflate(getLayoutInflater());
        setContentView(bindView.getRoot());

        bindView.subjects.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        SubjectsAdapter subjectsAdapter = new SubjectsAdapter(LoadMgr.getInstance().getSubjects());

        subjectsAdapter.setOnItemClickListener((adapter, view, position) -> {
            LoadMgr.getInstance().setCurrentSubject(subjectsAdapter.getItem(position));
            singleClickLock = false;
            ThemeIntroduceActivity.start(this);
        });

        bindView.subjects.setAdapter(subjectsAdapter);

        withClick(bindView.viewS, this);
    }

    @Override
    public void onClick(View v) {
        if (singleClickLock) {
            return;
        }
        singleClickLock = true;
        if (v.getId() == bindView.viewS.getId()) {
            singleClickLock = false;
            StationActivity.start(this); // 创想模块
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        MusicUtil.playAssetsAudio(MusicResource.WELCOME, mediaPlayer -> {
            MusicUtil.playAssetsAudio(MusicResource.DELAY);
            MusicUtil.playAssetsBgMusic(MusicResource.THEME);
        });

    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        singleClickLock = false;

        if (subscribe != null && !subscribe.isUnsubscribed()) {
            subscribe.unsubscribe();
            subscribe = null;
        }

        subscribe = rx.Observable.interval(20, 20, TimeUnit.SECONDS)
                .subscribeOn(rx.schedulers.Schedulers.newThread())
                .observeOn(rx.android.schedulers.AndroidSchedulers.mainThread())
                .subscribe(aLong -> MusicUtil.playAssetsAudio(MusicResource.DELAY));

    }

    @Override
    protected void onPause() {
        super.onPause();
        singleClickLock = false;
    }

    @Override
    protected void onStop() {
        super.onStop();
        MusicUtil.stopBgMusic();
        if (subscribe != null && !subscribe.isUnsubscribed()) {
            subscribe.unsubscribe();
            subscribe = null;
        }
    }

}