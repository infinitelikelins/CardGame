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

    public static FrameFragment newInstance(String fileName, int gapTime) {
        Bundle args = new Bundle();
        args.putString("framePath", fileName);
        args.putInt("gapTime", gapTime);
        FrameFragment fragment = new FrameFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private StageFrameBinding bindView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        bindView = StageFrameBinding.inflate(inflater, container, false);
        return bindView.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        if (getArguments() != null) {
            bindView.frameSurface.setBitmapPaths(getArguments().getString("framePath", null));
            bindView.frameSurface.setGapTime(getArguments().getInt("gapTime", 10));
        }
        bindView.frameSurface.setIsRepeat(false);
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