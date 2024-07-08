package com.bearya.robot.fairystory.ui.station;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;

import androidx.annotation.NonNull;

import com.airbnb.lottie.LottieAnimationView;
import com.bearya.robot.R;
import com.bearya.robot.base.util.ResourceUtil;

public class ImagePreViewDialog extends Dialog {

    public ImagePreViewDialog(@NonNull Activity activity, String photo) {
        super(activity, R.style.FullScreenDialog);
        setContentView(R.layout.dialog_image_preview);
        LottieAnimationView imageView = findViewById(R.id.iv_pre_view);
        if (TextUtils.isEmpty(photo)) {
            dismiss();
        } else if (photo.contains("storage")) {
            imageView.setImageBitmap(BitmapFactory.decodeFile(photo));
        } else {
            imageView.setImageResource(ResourceUtil.getMipmapId(photo));
        }
        imageView.setOnClickListener(v -> dismiss());
        setFullScreen();
    }

    private void setFullScreen() {
        Display display = getWindow().getWindowManager().getDefaultDisplay();
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.height = (display.getHeight()); //设置宽度
        lp.width = (display.getWidth()); //设置宽度
        getWindow().setAttributes(lp);
    }

}