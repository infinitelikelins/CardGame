package com.bearya.robot.fairystory.ui.stage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bearya.robot.base.ui.view.FrameSurfaceView;
import com.bearya.robot.databinding.StageFrameBinding;

public class FrameFragment extends Fragment {

    private FrameSurfaceView.OnFrameFinishedListener onFrameFinishedListener;
    private Bundle arguments;

    public static FrameFragment newInstance(String fileName, int gapTime, boolean repeat) {
        Bundle args = new Bundle();
        args.putString("framePath", fileName);
        args.putInt("gapTime", gapTime);
        args.putBoolean("repeat", repeat);
        FrameFragment fragment = new FrameFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private StageFrameBinding bindView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        arguments = getArguments();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        bindView = StageFrameBinding.inflate(inflater, container, false);
        return bindView.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        if (arguments != null) {
            bindView.frameSurface.setBitmapPaths(arguments.getString("framePath", null));
            bindView.frameSurface.setGapTime(arguments.getInt("gapTime", 10));
            bindView.frameSurface.setIsRepeat(arguments.getBoolean("repeat", false));
        }
        if (onFrameFinishedListener != null) {
            bindView.frameSurface.setOnFrameFinishedListener(onFrameFinishedListener);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        bindView.frameSurface.start();
    }

    public void setOnFrameFinishedListener(FrameSurfaceView.OnFrameFinishedListener listener) {
        onFrameFinishedListener = listener;
    }

}