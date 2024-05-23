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

    public static FrameFragment newInstance(int resId) {
        Bundle args = new Bundle();
        args.putInt("frame", resId);
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
        bindView = StageFrameBinding.inflate(inflater,container ,false);
        return bindView.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        bindView.frameSurface.setIsRepeat(false);
        bindView.frameSurface.setGapTime(10);
        bindView.frameSurface.setOnFrameFinishedListener(new FrameSurfaceView.OnFrameFinishedListener() {
            @Override
            public void onFrameStart() {

            }

            @Override
            public void onFrameFinish() {

            }
        });
        bindView.frameSurface.setOnClickListener(v -> {

        });
    }

}
