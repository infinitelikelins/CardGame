package com.bearya.robot.fairystory.ui.station;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bearya.robot.R;
import com.bearya.robot.base.ui.BaseActivity;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class CameraActivity extends BaseActivity {
    private CameraSurfaceView mCameraSurfaceView;
    private String mUri;
    View preViewLayout;
    ImageView btnOk;
    ImageView btnCancel;
    ImageView ivPreView;
    ImageView ivTakePhoto;
    private Camera.ShutterCallback mShutterCallback = () -> {

    };
    private Camera.PictureCallback rawPictureCallback = (data, camera) -> {

    };
    private Camera.PictureCallback jpegPictureCallback = new Camera.PictureCallback() {
        @Override
        public void onPictureTaken(byte[] data, Camera camera) {
            mCameraSurfaceView.startPreview();
            saveFile(data);
            ivTakePhoto.setVisibility(View.INVISIBLE);
            preViewLayout.setVisibility(View.VISIBLE);
            try {
                ivPreView.setImageBitmap(BitmapFactory.decodeFile(mUri));
            } catch (Exception e) {
                e.printStackTrace();
            }
            Toast.makeText(CameraActivity.this, getString(R.string.take_success), Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        ivTakePhoto = findViewById(R.id.img_take_photo);
        ivPreView = findViewById(R.id.iv_pre_view);
        preViewLayout = findViewById(R.id.pre_view_layout);
        btnOk = findViewById(R.id.btnOk);
        btnCancel = findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(view -> {
            preViewLayout.setVisibility(View.GONE);
            ivTakePhoto.setVisibility(View.VISIBLE);
        });
        btnOk.setOnClickListener(view -> {
            Intent data = new Intent();
            data.putExtra(MediaStore.EXTRA_OUTPUT,mUri);
            setResult(RESULT_OK,data);
            finish();
        });
        mCameraSurfaceView = findViewById(R.id.sv_camera);
        ivTakePhoto.setOnClickListener(v -> takePhoto());
        mUri = getIntent().getStringExtra(MediaStore.EXTRA_OUTPUT);
        findViewById(R.id.btnBack).setOnClickListener(view -> finish());
    }

    public void takePhoto() {
        mCameraSurfaceView.takePicture(mShutterCallback, rawPictureCallback, jpegPictureCallback);
    }

    public void saveFile(byte[] data) {
        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(mUri))){
            File file = new File(mUri);
            if(!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            bufferedOutputStream.write(data, 0, data.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
