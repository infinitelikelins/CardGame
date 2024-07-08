package com.bearya.robot.fairystory.ui.station;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bearya.actionlib.utils.KVManager;
import com.bearya.robot.R;
import com.bearya.robot.base.musicplayer.AudioRecorderManager;
import com.bearya.robot.base.util.DebugUtil;
import com.bearya.robot.base.util.MusicUtil;
import com.bearya.robot.databinding.FragmentStationRecordBinding;
import com.bearya.robot.fairystory.ui.res.FileResource;
import com.bearya.robot.fairystory.walk.car.LoadMgr;
import com.buihha.audiorecorder.Mp3Recorder;

import java.io.File;
import java.util.Locale;

public class StationRecordFragment extends Fragment {

    private FragmentStationRecordBinding bindView;
    private String type;
    private String filePath;
    private String fileName;
    private ObjectAnimator animator;
    private String key;

    private CountDownTimer timer;
    private long times = 0;

    public static StationRecordFragment newInstance(String type) {
        Bundle bundle = new Bundle();
        bundle.putString("type", type);
        StationRecordFragment fragment = new StationRecordFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        type = requireArguments().getString("type", "record_");
        key = LoadMgr.getInstance().getTheme().theme() + "_record_" + type;
        String sound = KVManager.getInstance().getString(key);

        filePath = TextUtils.isEmpty(sound) ? "" : sound.substring(0, sound.lastIndexOf("/") + 1);
        fileName = TextUtils.isEmpty(sound) ? "" : sound.substring(sound.lastIndexOf("/") + 1);

        DebugUtil.error("filePath = %s , fileName = %s", filePath, fileName);

        AudioRecorderManager.getInstance().init(new Mp3Recorder.OnRecordListener() {
            @Override
            public void onStart() {
                times = 0;
                if (timer != null) timer.start();
            }

            @Override
            public void onStop() {
                times = 0;
                if (timer != null) timer.cancel();
            }

            @Override
            public void onRecording(int sampleRate, double volume) {

            }

            @Override
            public void onError() {

            }
        });
        timer = new CountDownTimer(Long.MAX_VALUE, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                bindView.tvSecondRecord.setText(String.format(Locale.CHINA , "正在录音中... %d s" , ++times) );
            }

            @Override
            public void onFinish() {
                times = 0;
                bindView.tvSecondRecord.setText("录音已完成。");
            }
        };
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        bindView = FragmentStationRecordBinding.inflate(inflater, container, false);
        return bindView.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        bindView.ivPreView.setVisibility(TextUtils.isEmpty(fileName) ? View.GONE : View.VISIBLE);

        bindView.ivSound.setOnClickListener(v -> {
            v.setSelected(!v.isSelected());
            if (v.isSelected()) startRecord();
            else stopRecord();
        });
        bindView.ivPreView.setOnClickListener(v -> {
            v.setSelected(!v.isSelected());
            if (v.isSelected()) playRecord();
            else stopPlayRecord();
        });
        bindView.ivPreView.setOnLongClickListener(v -> deleteRecordFile());

    }

    private void stopRecord() {
        bindView.ivPreView.setImageResource(R.drawable.ic_listener_selector);
        bindView.ivPreView.setVisibility(View.VISIBLE);
        bindView.tvSecondRecord.setText("");
        stopRotate(bindView.ivSound);
        AudioRecorderManager.getInstance().stop();
    }

    private void startRecord() {
        deleteRecordFile();
        bindView.ivPreView.setVisibility(View.GONE);
        bindView.tvSecondRecord.setText("正在录音中...");
        startRotate(bindView.ivSound);
        filePath = FileResource.BASE_PATH + LoadMgr.getInstance().getTheme().theme() + "/record/";
        fileName = System.currentTimeMillis() + ".mp3";
        KVManager.getInstance().put(key, filePath + "/" + fileName);
        File file = new File(filePath);
        if (!file.exists()) file.mkdirs();
        AudioRecorderManager.getInstance().startRecord(filePath, fileName);
    }

    private void stopPlayRecord() {
        MusicUtil.stopMusic();
        bindView.ivPreView.setSelected(false);
        stopRotate(bindView.ivPreView);
        bindView.tvSecondRecord.setText("");
    }

    /**
     * 播放MP3
     */
    private void playRecord() {
        if (AudioRecorderManager.getInstance().isRecording()) {
            AudioRecorderManager.getInstance().stop();
        } else {
            bindView.tvSecondRecord.setText("正在播放音频中...");
            bindView.ivPreView.setVisibility(View.VISIBLE);
        }
        try {
            MusicUtil.playMusic(filePath + fileName, mp -> {
                stopRotate(bindView.ivPreView);
                bindView.tvSecondRecord.setText("");
                bindView.ivPreView.setSelected(false);
            });
            startRotate(bindView.ivPreView);
        } catch (Exception e) {
            bindView.ivPreView.setSelected(false);
        }
    }

    private void startRotate(View view) {
        if (animator != null) {
            stopRotate(view);
        }
        animator = ObjectAnimator.ofFloat(view, "rotation", 0, 359);
        animator.setDuration(8000);
        animator.setInterpolator(new LinearInterpolator());
        animator.setRepeatMode(ValueAnimator.RESTART);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.start();
    }

    private void stopRotate(View view) {
        if (animator != null) {
            animator.cancel();
            animator = null;
        }
        view.setRotation(0);
    }

    private boolean deleteRecordFile() {
        stopRotate(bindView.ivPreView);
        stopRecord();
        stopPlayRecord();
        bindView.ivPreView.setVisibility(View.GONE);
        KVManager.getInstance().remove(LoadMgr.getInstance().getTheme().theme() + "_record_" + type);
        File file = new File(filePath, fileName);
        return file.exists() && file.delete();
    }

    @Override
    public void onStop() {
        super.onStop();
        stopRecord();
        stopPlayRecord();
        if (timer != null) timer.cancel();
    }

}