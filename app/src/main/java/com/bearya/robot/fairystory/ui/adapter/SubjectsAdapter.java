package com.bearya.robot.fairystory.ui.adapter;

import androidx.annotation.Nullable;

import com.bearya.robot.R;
import com.bearya.robot.fairystory.walk.subjects.AbsSubject;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class SubjectsAdapter extends BaseQuickAdapter<AbsSubject, BaseViewHolder> {

    public SubjectsAdapter(@Nullable List<AbsSubject> data) {
        super(R.layout.item_subject, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, AbsSubject item) {
        helper.setImageResource(R.id.item_image, item.res());
    }

}
