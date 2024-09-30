package com.bearya.robot.fairystory.ui.stage;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bearya.robot.databinding.StageAnimationBinding;

public class AnimationFragment extends Fragment {

    private StageAnimationBinding bindView;
    private AnimationDrawable drawable;
    public static AnimationFragment newInstance(int fileName) {
        Bundle args = new Bundle();
        args.putInt("pictureRes", fileName);
        AnimationFragment fragment = new AnimationFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        bindView = StageAnimationBinding.inflate(inflater, container, false);
        return bindView.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        assert getArguments() != null;
        int pictureRes = getArguments().getInt("pictureRes", 0);
        bindView.picture.setBackgroundResource(pictureRes);

        drawable = (AnimationDrawable) bindView.picture.getBackground();
        drawable.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        drawable.stop();
    }
}