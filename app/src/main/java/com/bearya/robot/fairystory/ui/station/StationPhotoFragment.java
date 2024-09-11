package com.bearya.robot.fairystory.ui.station;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bearya.actionlib.utils.KVManager;
import com.bearya.robot.base.util.DebugUtil;
import com.bearya.robot.base.util.ResourceUtil;
import com.bearya.robot.databinding.FragmentStationPhotoBinding;
import com.bearya.robot.fairystory.ui.res.FileResource;
import com.bearya.robot.fairystory.walk.car.LoadMgr;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.io.File;

public class StationPhotoFragment extends Fragment {

    private FragmentStationPhotoBinding bindView;

    private String filePath;
    private String photoPath;
    private String key;

    private ActivityResultLauncher<String> openCameraLauncher;

    public static StationPhotoFragment newInstance(String type) {
        Bundle bundle = new Bundle();
        bundle.putString("type", type);
        StationPhotoFragment fragment = new StationPhotoFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String type = requireArguments().getString("type", "Photo_");
        filePath = FileResource.BASE_PATH + LoadMgr.getInstance().getTheme().theme() + "/photo/";
        key = LoadMgr.getInstance().getTheme().theme() + "_photo_" + type;
        openCameraLauncher = registerForActivityResult(new ActivityResultContract<String, String>() {
            @NonNull
            @Override
            public Intent createIntent(@NonNull Context context, String input) {
                return new Intent(getActivity(), CameraActivity.class).putExtra(MediaStore.EXTRA_OUTPUT, input);
            }

            @Override
            public String parseResult(int resultCode, @Nullable Intent intent) {
                String result = intent.getStringExtra(MediaStore.EXTRA_OUTPUT);
                KVManager.getInstance().put(key, result);
                return result;
            }
        }, result -> showFace());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        bindView = FragmentStationPhotoBinding.inflate(inflater, container, false);
        return bindView.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        showFace();
        bindView.ivTakePhoto.setOnClickListener(v -> takePhoto());
        bindView.ivPreView.setOnClickListener(v -> new ImagePreViewDialog(requireActivity(), photoPath).show());
        bindView.ivPreView.setOnLongClickListener(v -> {
            deleteFile();
            return true;
        });
    }

    private void takePhoto() {
        deleteFile();
        // 步骤一：创建存储照片的文件
        File file = new File(filePath, System.currentTimeMillis() + ".jpg");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        //步骤四：调取系统拍照
        openCameraLauncher.launch(file.getAbsolutePath());
    }

    private void showFace() {
        photoPath = KVManager.getInstance().getString(key);
        DebugUtil.error("photoPath = %s", photoPath);
        if (TextUtils.isEmpty(photoPath)) {
            bindView.ivPreView.setVisibility(View.GONE);
            bindView.ivPreView.setImageResource(0);
        } else if (photoPath.contains("storage")) {
            bindView.ivPreView.setVisibility(View.VISIBLE);
            Glide.with(this).setDefaultRequestOptions(
                    new RequestOptions()
                            .circleCrop()
                            .diskCacheStrategy(DiskCacheStrategy.NONE)
                            .skipMemoryCache(true)
            ).load(photoPath).into(bindView.ivPreView);
        } else if (!TextUtils.isEmpty(photoPath)) {
            bindView.ivPreView.setVisibility(View.VISIBLE);
            Glide.with(this).setDefaultRequestOptions(
                    new RequestOptions()
                            .diskCacheStrategy(DiskCacheStrategy.NONE)
                            .skipMemoryCache(true)
            ).load(ResourceUtil.getMipmapId(photoPath)).centerCrop().into(bindView.ivPreView);
        }
    }

    private void deleteFile() {
        if (TextUtils.isEmpty(photoPath)) return;
        File file = new File(photoPath);
        if (file.exists()) {
            file.delete();
        }
        KVManager.getInstance().remove(key);
        bindView.ivPreView.setVisibility(View.GONE);
        bindView.ivPreView.setImageResource(0);
    }

}
