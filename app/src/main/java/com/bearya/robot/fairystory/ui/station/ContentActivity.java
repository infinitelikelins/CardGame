package com.bearya.robot.fairystory.ui.station;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.viewpager.widget.ViewPager;

import com.bearya.robot.R;
import com.bearya.robot.base.ui.BaseActivity;
import com.bearya.robot.base.util.MusicUtil;
import com.bearya.robot.databinding.ActivityContentBinding;
import com.bearya.robot.fairystory.ui.res.MusicResource;

import java.util.Objects;

public class ContentActivity extends BaseActivity {

    public static void start(Context context, String type) {
        MusicUtil.playMusic(MusicResource.BASE_STATION_PATH +"station_"+ type + "_.mp3",
                mp -> context.startActivity(new Intent(context, ContentActivity.class).putExtra("type", type)));
    }

    private ActivityContentBinding bindView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindView = ActivityContentBinding.inflate(getLayoutInflater());
        setContentView(bindView.getRoot());

        String type = getIntent().getStringExtra("type");

        ContentAdapter contentAdapter = new ContentAdapter(getSupportFragmentManager(), type);
        bindView.viewPager.setAdapter(contentAdapter);
        bindView.viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        bindView.contentBackground.setBackgroundResource(R.mipmap.station_bg1);
                        MusicUtil.playMusic(MusicResource.BASE_STATION_PATH + "station_image.mp3");
                        break;
                    case 1:
                        bindView.contentBackground.setBackgroundResource(R.mipmap.station_bg2);
                        MusicUtil.playMusic(MusicResource.BASE_STATION_PATH + "station_action.mp3");
                        break;
                    case 2:
                        bindView.contentBackground.setBackgroundResource(R.mipmap.station_bg3);
                        MusicUtil.playMusic(MusicResource.BASE_STATION_PATH + "station_sound.mp3");
                        break;
                    case 3:
                        bindView.contentBackground.setBackgroundResource(R.mipmap.station_bg3);
                        break;
                }
            }
        });
        bindView.tabs.setupWithViewPager(bindView.viewPager);

        for (int i = 0; i < contentAdapter.getCount(); i++) {
            Objects.requireNonNull(bindView.tabs.getTabAt(i)).setIcon(contentAdapter.getIcon(i));
        }

    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        MusicUtil.playMusic(MusicResource.BASE_STATION_PATH + "station_image.mp3");
    }

}