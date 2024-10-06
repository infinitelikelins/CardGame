package com.bearya.robot.fairystory.ui.popup.impl;

import android.content.Context;
import android.view.View;

import com.bearya.robot.R;
import com.bearya.robot.fairystory.ui.popup.AbsBasePopup;

public class TransparentPopup extends AbsBasePopup {

    public TransparentPopup(Context context) {
        super(context);
    }

    @Override
    protected int inflateLayoutId() {
        return R.layout.popup_transparent;
    }

    @Override
    protected int onPopupShowDuration() {
        return 100;
    }

    @Override
    protected int onPopupDismissDuration() {
        return 100;
    }

    public TransparentPopup withEvent(View.OnClickListener onClick) {
        withClick(R.id.transparent, onClick);
        return this;
    }

}