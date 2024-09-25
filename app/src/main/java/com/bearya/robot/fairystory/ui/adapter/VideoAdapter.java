package com.bearya.robot.fairystory.ui.adapter;

import android.text.TextUtils;

import androidx.annotation.NonNull;

import com.bearya.actionlib.utils.KVManager;
import com.bearya.robot.R;
import com.bearya.robot.base.ui.view.NiceImageView;
import com.bearya.robot.fairystory.ui.station.LibItem;
import com.bearya.robot.fairystory.walk.car.LoadMgr;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;
import java.util.Objects;

public class VideoAdapter extends BaseQuickAdapter<LibItem, BaseViewHolder> {

    private final String type;
    private int selectedIndex = -1;

    public VideoAdapter(String type) {
        super(R.layout.lib_item_view);
        this.type = type;
    }

    public void setSelectedIndex(int index) {
        String key = LoadMgr.getInstance().getTheme().theme() + "_video_" + type;
        if (index == selectedIndex) {
            selectedIndex = -1;
            KVManager.getInstance().remove(key);
        } else {
            String video = Objects.requireNonNull(getItem(index)).getVideo();
            KVManager.getInstance().put(key, video);
            notifyItemChanged(selectedIndex,"video");
        }
        notifyItemChanged(index,"video");
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position, @NonNull List<Object> payloads) {
        if (!payloads.isEmpty()) {
            LibItem item = getItem(position);
            String value = KVManager.getInstance().getString(LoadMgr.getInstance().getTheme().theme() + "_video_" + type);
            boolean isSelected = TextUtils.equals(value, item.getVideo());
            if (isSelected)
                selectedIndex = holder.getBindingAdapterPosition();
            NiceImageView view = holder.getView(R.id.iconView);
            view.setBorderColor(view.getContext().getResources().getColor(R.color.colorRed));
            view.setBorderWidth(isSelected ? 6 : 0);
        } else {
            super.onBindViewHolder(holder, position, payloads);
        }
    }

    @Override
    protected void convert(BaseViewHolder helper, LibItem item) {
        NiceImageView view = helper.getView(R.id.iconView);

        Glide.with(mContext).setDefaultRequestOptions(
                new RequestOptions()
                        .frame(10)
                        .skipMemoryCache(true)
                        .fitCenter()
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .skipMemoryCache(true)
        ).load(item.getVideo()).thumbnail(0.8f).into(view);

        helper.setText(R.id.nameView, item.getName());

        String value = KVManager.getInstance().getString(LoadMgr.getInstance().getTheme().theme() + "_video_" + type);
        boolean isSelected = TextUtils.equals(value, item.getVideo());
        if (isSelected)
            selectedIndex = helper.getBindingAdapterPosition();
        view.setBorderColor(view.getContext().getResources().getColor(R.color.colorRed));
        view.setBorderWidth(isSelected ? 6 : 0);
    }

}