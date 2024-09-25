package com.bearya.robot.fairystory.ui.popup.impl;

import android.content.Context;
import android.text.TextUtils;

import com.bearya.actionlib.utils.KVManager;
import com.bearya.robot.R;
import com.bearya.robot.base.ui.view.NiceImageView;
import com.bearya.robot.fairystory.ui.popup.AbsBasePopup;

public class LottieMotionPopup extends AbsBasePopup {

    private NiceImageView emotionAxy;
    private NiceImageView emotionCheng;
    private NiceImageView emotionHs;
    private NiceImageView emotionHg;
    private NiceImageView emotionJa;
    private NiceImageView emotionShe;
    private NiceImageView emotionSq;

    public LottieMotionPopup(Context context) {
        super(context);
    }

    @Override
    protected int inflateLayoutId() {
        return R.layout.popup_lottie_motion;
    }

    @Override
    protected void onViewInflated() {


        emotionAxy = findViewById(R.id.emotion_axy);
        emotionCheng = findViewById(R.id.emotion_cheng);
        emotionHg = findViewById(R.id.emotion_hg);
        emotionHs = findViewById(R.id.emotion_hs);
        emotionJa = findViewById(R.id.emotion_ja);
        emotionShe = findViewById(R.id.emotion_she);
        emotionSq = findViewById(R.id.emotion_sq);

        withExtClicks(emotionCheng, emotionShe, emotionAxy, emotionHg, emotionJa, emotionSq, emotionHs);

        updateEmotion(emotionCheng, emotionShe, emotionAxy, emotionHg, emotionJa, emotionSq, emotionHs);

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
        updateEmotion(emotionCheng, emotionShe, emotionAxy, emotionHg, emotionJa, emotionSq, emotionHs);

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