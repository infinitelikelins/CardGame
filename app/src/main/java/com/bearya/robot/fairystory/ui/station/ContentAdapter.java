package com.bearya.robot.fairystory.ui.station;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.bearya.robot.R;

public class ContentAdapter extends FragmentStatePagerAdapter {

    private final String type;

    public ContentAdapter(FragmentManager fm, String type) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.type = type;
    }

    @Override
    public int getCount() {
        return 6;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: return StationImageFragment.newInstance(type);
            case 1: return StationActionFragment.newInstance(type);
            case 2: return StationSoundFragment.newInstance(type);
            case 3: return StationRecordFragment.newInstance(type);
            case 4: return StationPhotoFragment.newInstance(type);
            case 5: return StationVideoFragment.newInstance(type);
            default: return new Fragment();
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0: return "图片";
            case 1: return "动作";
            case 2: return "声音";
            case 3: return "录音";
            case 4: return "拍照";
            case 5: return "视频";
            default: return "";
        }
    }

    public int getIcon(int index) {
        switch (index) {
            case 0: return R.drawable.station_tab_image_selector;
            case 1: return R.drawable.station_tab_action_selector;
            case 2: return R.drawable.station_tab_sound_selector;
            case 3: return R.drawable.station_tab_image_selector;
            case 4: return R.drawable.station_tab_image_selector;
            case 5: return R.drawable.station_tab_image_selector;
            default: return R.drawable.station_tab_image_selector;
        }
    }

}