package com.bearya.robot.fairystory.ui.adapter;

import android.text.TextUtils;

import com.bearya.actionlib.utils.KVManager;
import com.bearya.robot.R;
import com.bearya.robot.base.ui.view.NiceImageView;
import com.bearya.robot.base.util.DebugUtil;
import com.bearya.robot.fairystory.ui.station.LibItem;
import com.bearya.robot.fairystory.walk.car.LoadMgr;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.Objects;

public class SoundAdapter extends BaseQuickAdapter<LibItem, BaseViewHolder> {

    private final String type;

    public SoundAdapter(String type) {
        super(R.layout.lib_item_view);
        this.type = type;
    }

    public void setSelectedIndex(int index) {
        String mp3 = Objects.requireNonNull(getItem(index)).getMp3();
        String key = LoadMgr.getInstance().getTheme().theme() + "_sound_" + type;

        DebugUtil.debug("key = " + key + " , mp3 = " + mp3);
        KVManager.getInstance().put(key, mp3);

        notifyItemRangeChanged(0, getItemCount());
    }

    @Override
    protected void convert(BaseViewHolder helper, LibItem item) {
        NiceImageView view = helper.getView(R.id.iconView);

        Glide.with(mContext).setDefaultRequestOptions(
                new RequestOptions()
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .skipMemoryCache(true)
        ).load(item.getImage()).thumbnail(0.8f).into(view);
        helper.setText(R.id.nameView, item.getName());

        boolean isSelected = TextUtils.equals(KVManager.getInstance().getString(LoadMgr.getInstance().getTheme().theme() + "_sound_" + type), item.getMp3());
        view.setBorderColor(view.getContext().getResources().getColor(R.color.colorRed));
        view.setBorderWidth(isSelected ? 6 : 0);

    }

}
