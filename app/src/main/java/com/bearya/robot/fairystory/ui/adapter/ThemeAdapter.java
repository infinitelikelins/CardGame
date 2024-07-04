package com.bearya.robot.fairystory.ui.adapter;

import com.bearya.robot.R;
import com.bearya.robot.fairystory.walk.themes.AbsTheme;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

public class ThemeAdapter extends BaseQuickAdapter<AbsTheme, BaseViewHolder> {

    public ThemeAdapter() {
        super(R.layout.item_theme);
    }

    @Override
    protected void convert(BaseViewHolder helper, AbsTheme item) {
        helper.setBackgroundRes(R.id.name, item.res() > 0 ? item.res() : R.color.colorBlueBackground);
        helper.setText(R.id.name, item.theme());
    }

}
