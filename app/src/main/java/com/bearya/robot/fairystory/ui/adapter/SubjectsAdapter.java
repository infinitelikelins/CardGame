package com.bearya.robot.fairystory.ui.adapter;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

import com.bearya.robot.R;
import com.bearya.robot.fairystory.walk.subjects.AbsSubject;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class SubjectsAdapter extends BaseQuickAdapter<AbsSubject, BaseViewHolder> {

    public SubjectsAdapter(@Nullable List<AbsSubject> data) {
        super(R.layout.item_subject, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, AbsSubject item) {
        Glide.with(mContext).setDefaultRequestOptions(
                new RequestOptions()
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .skipMemoryCache(true)
        ).load(item.tabImage()).error(R.mipmap.fairy_body).into((AppCompatImageView) helper.getView(R.id.item_image));
    }

}
