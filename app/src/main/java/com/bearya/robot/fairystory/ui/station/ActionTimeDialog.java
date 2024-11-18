package com.bearya.robot.fairystory.ui.station;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;

import androidx.annotation.NonNull;

import com.bearya.robot.R;
import com.bearya.robot.base.util.MusicUtil;
import com.bearya.robot.base.util.ResourceUtil;
import com.bearya.robot.fairystory.ui.res.MusicResource;

import java.util.Locale;

public class ActionTimeDialog extends Dialog implements View.OnClickListener {

    private ActionTimeListener listener;

    public ActionTimeDialog(@NonNull Activity activity) {
        super(activity, R.style.FullScreenDialog);
        setContentView(R.layout.dialog_station_times);
        setCanceledOnTouchOutside(true);

        for (int i = 1; i <= 10; i++) {
            findViewById(ResourceUtil.getId(getContext(), "tv" + i)).setOnClickListener(this);
        }
        MusicUtil.playMusic(MusicResource.BASE_STATION_PATH + "station_action_select_time.mp3");
    }

    @Override
    public void onClick(View view) {
        String section = (String) view.getTag();
        MusicUtil.playMusic(String.format(Locale.CHINA,MusicResource.BASE_STATION_PATH + "station_action_time_%s.mp3", section));
        if (listener != null)
            listener.onActionTime(Integer.parseInt(section));
        dismiss();
    }

    public ActionTimeDialog setListener(ActionTimeListener listener) {
        this.listener = listener;
        return this;
    }

    public interface ActionTimeListener {
        void onActionTime(int second);
    }

}