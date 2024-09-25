package com.bearya.robot.fairystory.ui.station;

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.VideoView;

import androidx.annotation.NonNull;

import com.bearya.robot.R;

public class VideoPreviewDialog extends Dialog {

    public VideoPreviewDialog(@NonNull Activity activity, String videoPath) {
        super(activity, R.style.FullScreenDialog);
        View inflateView = getLayoutInflater().inflate(R.layout.dialog_video_preview, null, false);
        setContentView(inflateView);
        VideoView videoView = findViewById(R.id.video_view);
        if (TextUtils.isEmpty(videoPath)) {
            dismiss();
            return;
        } else {
            videoView.setVideoPath(videoPath);
            videoView.setOnCompletionListener(mp -> dismiss());
        }
        inflateView.setOnClickListener(v -> dismiss());
        setCanceledOnTouchOutside(true);
        setOnDismissListener(dialog -> videoView.stopPlayback());
        setOnShowListener(dialog -> videoView.start());
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