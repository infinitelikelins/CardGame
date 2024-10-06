package com.bearya.robot.fairystory.ui.popup.impl;

import android.content.Context;
import android.text.TextUtils;

import com.bearya.actionlib.utils.KVManager;
import com.bearya.robot.R;
import com.bearya.robot.base.ui.view.NiceImageView;
import com.bearya.robot.fairystory.ui.popup.AbsBasePopup;

public class LottieMotionPopup extends AbsBasePopup {

    private NiceImageView emotionSh;
    private NiceImageView emotionCheng;
    private NiceImageView emotionZm;
    private NiceImageView emotionMy;
    private NiceImageView emotionSmq;
    private NiceImageView emotionShe;
    private NiceImageView emotionSq;
    private NiceImageView emotionZc;

    public LottieMotionPopup(Context context) {
        super(context);
    }

    @Override
    protected int inflateLayoutId() {
        return R.layout.popup_lottie_motion;
    }

    @Override
    protected void onViewInflated() {

        emotionSh = findViewById(R.id.emotion_sh);
        emotionCheng = findViewById(R.id.emotion_cheng);
        emotionMy = findViewById(R.id.emotion_my);
        emotionZm = findViewById(R.id.emotion_zm);
        emotionSmq = findViewById(R.id.emotion_smq);
        emotionShe = findViewById(R.id.emotion_she);
        emotionSq = findViewById(R.id.emotion_sq);
        emotionZc = findViewById(R.id.emotion_zc);

        withExtClicks(emotionCheng, emotionShe, emotionSh, emotionMy, emotionSmq, emotionSq, emotionZm, emotionZc);

        updateEmotion(emotionCheng, emotionShe, emotionSh, emotionMy, emotionSmq, emotionSq, emotionZm, emotionZc);

        withClick(R.id.btnBack, v -> dismiss(true));

        setOutSideDismiss(true);
        setWidth(1200);
    }

    private void exclusive(NiceImageView imageView) {
        // 1. 获取点击的图标
        String tag = (String) imageView.getTag();
        // 2. 获取存储的表情（上一次）
        String emotion = KVManager.getInstance().getString("emotion", null);
        // 3. 如果1==2,那么点击的项目是需要取消；如果1!=2,那么点击的项目是新设置的被选中项
        boolean selected = !TextUtils.equals(tag, emotion);
        // 4. 将3的结果放入存储
        KVManager.getInstance().put("emotion", selected ? tag : null);
        // 5. 更新图标
        updateEmotion(emotionCheng, emotionShe, emotionSh, emotionMy, emotionSmq, emotionSq, emotionZm, emotionZc);

    }

    private void updateEmotion(NiceImageView... imageViews) {
        String emotion = KVManager.getInstance().getString("emotion", null);
        for (NiceImageView imageView : imageViews) {
            String tag = (String) imageView.getTag();
            imageView.setBorderWidth(TextUtils.equals(tag, emotion) ? 4 : 0);
        }
    }

    private void withExtClicks(NiceImageView... imageViews) {
        for (NiceImageView imageView : imageViews) {
            imageView.setOnClickListener(v -> exclusive(imageView));
        }
    }

}