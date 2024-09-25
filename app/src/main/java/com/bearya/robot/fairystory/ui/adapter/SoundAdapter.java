package com.bearya.robot.fairystory.ui.adapter;

import android.text.TextUtils;

import com.bearya.actionlib.utils.KVManager;
import com.bearya.robot.R;
import com.bearya.robot.base.ui.view.NiceImageView;
import com.bearya.robot.base.util.MusicUtil;
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
    private int selectedIndex = -1;

    public SoundAdapter(String type) {
        super(R.layout.lib_item_view);
        this.type = type;
    }

    public void setSelectedIndex(int index) {
        String key = LoadMgr.getInstance().getTheme().theme() + "_sound_" + type;
        if (index == selectedIndex) {
            selectedIndex = -1;
            KVManager.getInstance().remove(key);
            MusicUtil.stopMusic();
        } else {
            String mp3 = Objects.requireNonNull(getItem(index)).getSound();
            KVManager.getInstance().put(key, mp3);
            MusicUtil.playMusic(mp3);
            notifyItemChanged(selectedIndex);
        }
        notifyItemChanged(index);
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

        String value = KVManager.getInstance().getString(LoadMgr.getInstance().getTheme().theme() + "_sound_" + type);
        boolean isSelected = TextUtils.equals(value, item.getSound());
        if (isSelected)
            selectedIndex = helper.getBindingAdapterPosition();
        view.setBorderColor(view.getContext().getResources().getColor(R.color.colorRed));
        view.setBorderWidth(isSelected ? 6 : 0);
    }

}
