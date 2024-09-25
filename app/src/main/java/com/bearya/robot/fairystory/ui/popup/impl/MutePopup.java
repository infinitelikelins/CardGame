package com.bearya.robot.fairystory.ui.popup.impl;

import android.content.Context;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.core.content.res.ResourcesCompat;

import com.bearya.robot.R;
import com.bearya.robot.fairystory.ui.popup.AbsBasePopup;
import com.bearya.robot.fairystory.walk.subjects.AbsSubject;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

public class MutePopup extends AbsBasePopup {

    private final AbsSubject subject;

    public MutePopup(Context context, AbsSubject subject) {
        super(context);
        this.subject = subject;
    }

    @Override
    protected int inflateLayoutId() {
        return R.layout.popup_mute;
    }

    @Override
    protected void onViewInflated() {
        getContentView().setOnClickListener(v -> {
            subject.muteChange();
            statusChange();
        });

        setOutSideDismiss(true);
        setWidth(800);
    }

    @Override
    protected void onPopupShow() {
        super.onPopupShow();
        statusChange();
    }

    private void statusChange() {
        boolean mute = subject.mute();
        CardView itemView = findViewById(R.id.card_view);
        itemView.setCardBackgroundColor(ResourcesCompat.getColor(getContext().getResources(), mute ? R.color.colorPopupBackground : R.color.colorViolet, null));

        AppCompatTextView name = findViewById(R.id.name);
        name.setText(subject.name());
        name.setTextColor(ResourcesCompat.getColor(getContext().getResources(), mute ? R.color.colorPopupText : R.color.colorOrange, null));

        AppCompatTextView status = findViewById(R.id.status);
        status.setText(mute ? "音效已关闭" : "音效已开启");
        status.setTextColor(ResourcesCompat.getColor(getContext().getResources(), mute ? R.color.colorPopupText : R.color.colorOrange, null));

        Glide.with(getContentView()).setDefaultRequestOptions(
                new RequestOptions()
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .skipMemoryCache(true)
        ).load(subject.tabImage()).error(R.mipmap.fairy_body).into((AppCompatImageView) findViewById(R.id.item_image));
    }

}
