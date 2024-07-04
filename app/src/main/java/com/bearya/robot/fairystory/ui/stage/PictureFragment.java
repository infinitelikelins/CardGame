package com.bearya.robot.fairystory.ui.stage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bearya.robot.databinding.StagePictureBinding;
import com.bumptech.glide.Glide;

public class PictureFragment extends Fragment {

    private StagePictureBinding bindView;

    public static PictureFragment newInstance(int fileName) {
        Bundle args = new Bundle();
        args.putInt("pictureRes", fileName);
        PictureFragment fragment = new PictureFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public static PictureFragment newInstance(String filePath) {
        Bundle args = new Bundle();
        args.putString("picturePath" , filePath);
        PictureFragment fragment = new PictureFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        bindView = StagePictureBinding.inflate(inflater, container, false);
        return bindView.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        assert getArguments() != null;
        int pictureRes = getArguments().getInt("pictureRes", 0);
        String picturePath = getArguments().getString("picturePath",null);
        if (pictureRes != 0) {
            bindView.picture.setBackgroundResource(pictureRes);
        } else if (picturePath != null) {
            Glide.with(requireContext()).load(picturePath).into(bindView.picture);
        }
    }

}