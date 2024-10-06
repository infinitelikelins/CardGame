package com.bearya.robot.fairystory.ui.station;

import android.os.Bundle;
import android.util.ArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bearya.actionlib.utils.KVManager;
import com.bearya.robot.R;
import com.bearya.robot.base.play.TimeAction;
import com.bearya.robot.databinding.FragmentStationActionBinding;
import com.bearya.robot.fairystory.walk.car.LoadMgr;

import java.util.Map;

public class StationActionFragment extends Fragment implements View.OnClickListener, View.OnLongClickListener {

    private final Map<Integer, Integer> actionMap = new ArrayMap<>();
    private String type;

    public static StationActionFragment newInstance(String type) {
        Bundle bundle = new Bundle();
        bundle.putString("type", type);
        StationActionFragment actionFragment = new StationActionFragment();
        actionFragment.setArguments(bundle);
        return actionFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        type = requireArguments().getString("type", "station_");

        actionMap.put(ActionSetDialog.ACTION_DOUBLE_HAND, R.mipmap.ic_shake_hand_select);
        actionMap.put(ActionSetDialog.ACTION_LEFT_HAND, R.mipmap.ic_shake_left_hand_select);
        actionMap.put(ActionSetDialog.ACTION_RIGHT_HAND, R.mipmap.ic_shake_right_hand_select);
        actionMap.put(ActionSetDialog.ACTION_SHAKE_HEADER, R.mipmap.ic_shake_head_select);
        actionMap.put(ActionSetDialog.ACTION_SHAKE_HEADER_TO_LEFT, R.mipmap.ic_shake_head_to_left_select);
        actionMap.put(ActionSetDialog.ACTION_SHAKE_HEADER_TO_RIGHT, R.mipmap.ic_shake_head_to_right_select);
    }

    private FragmentStationActionBinding bindView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        bindView = FragmentStationActionBinding.inflate(inflater, container, false);
        return bindView.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bindView.box1.setOnClickListener(this);
        bindView.box2.setOnClickListener(this);
        bindView.box3.setOnClickListener(this);
        bindView.box1.setOnLongClickListener(this);
        bindView.box2.setOnLongClickListener(this);
        bindView.box3.setOnLongClickListener(this);
        bindView.tvSecond1.setOnClickListener(this);
        bindView.tvSecond2.setOnClickListener(this);
        bindView.tvSecond3.setOnClickListener(this);

        int action1 = KVManager.getInstance().getInt(LoadMgr.getInstance().getTheme().theme() + "_action_" + type + "1", 0);
        int action2 = KVManager.getInstance().getInt(LoadMgr.getInstance().getTheme().theme() + "_action_" + type + "2", 0);
        int action3 = KVManager.getInstance().getInt(LoadMgr.getInstance().getTheme().theme() + "_action_" + type + "3", 0);

        int time1 = KVManager.getInstance().getInt(LoadMgr.getInstance().getTheme().theme() + "_time_" + type + "1", 3000);
        int time2 = KVManager.getInstance().getInt(LoadMgr.getInstance().getTheme().theme() + "_time_" + type + "2", 3000);
        int time3 = KVManager.getInstance().getInt(LoadMgr.getInstance().getTheme().theme() + "_time_" + type + "3", 3000);

        setActionToView(new TimeAction(action1, time1), bindView.box1, bindView.tvSecond1);
        setActionToView(new TimeAction(action2, time2), bindView.box2, bindView.tvSecond2);
        setActionToView(new TimeAction(action3, time3), bindView.box3, bindView.tvSecond3);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.box1 || id == R.id.box2 || id == R.id.box3) {
            new ActionSetDialog(requireActivity()).setListener(action -> {
                TimeAction timeAction = new TimeAction(action, 3000);
                if (view.getId() == bindView.box1.getId()) {
                    KVManager.getInstance().put(LoadMgr.getInstance().getTheme().theme() + "_action_" + type + "1", action);
                    setActionToView(timeAction, bindView.box1, bindView.tvSecond1);
                } else if (view.getId() == bindView.box2.getId()) {
                    KVManager.getInstance().put(LoadMgr.getInstance().getTheme().theme() + "_action_" + type + "2", action);
                    setActionToView(timeAction, bindView.box2, bindView.tvSecond2);
                } else if (view.getId() == bindView.box3.getId()) {
                    KVManager.getInstance().put(LoadMgr.getInstance().getTheme().theme() + "_action_" + type + "3", action);
                    setActionToView(timeAction, bindView.box3, bindView.tvSecond3);
                }
            }).show();
        } else if (id == R.id.tvSecond1 || id == R.id.tvSecond2 || id == R.id.tvSecond3) {
            new ActionTimeDialog(requireActivity(), 0).setListener(time -> {
                if (view.getId() == R.id.tvSecond1) {
                    KVManager.getInstance().put(LoadMgr.getInstance().getTheme().theme() + "_time_" + type + "1", time * 1000L);
                    bindView.tvSecond1.setText(String.format(getString(R.string.some_second), time));
                } else if (view.getId() == R.id.tvSecond2) {
                    KVManager.getInstance().put(LoadMgr.getInstance().getTheme().theme() + "_time_" + type + "2", time * 1000L);
                    bindView.tvSecond2.setText(String.format(getString(R.string.some_second), time));
                } else if (view.getId() == R.id.tvSecond3) {
                    KVManager.getInstance().put(LoadMgr.getInstance().getTheme().theme() + "_time_" + type + "3", time * 1000L);
                    bindView.tvSecond3.setText(String.format(getString(R.string.some_second), time));
                }
            }).show();
        }
    }

    private void setActionToView(TimeAction action, ImageView view, TextView textView) {
        if (action.getAction() == 0) return;
        view.setImageResource(actionMap.get(action.getAction()));
        textView.setVisibility(View.VISIBLE);
        textView.setText(String.format(getString(R.string.some_second), action.getTime() / 1000));
    }

    @Override
    public boolean onLongClick(View view) {
        if (view.getId() == bindView.box1.getId()) {
            KVManager.getInstance().remove(LoadMgr.getInstance().getTheme().theme() + "_action_" + type + "1");
            KVManager.getInstance().remove(LoadMgr.getInstance().getTheme().theme() + "_time_" + type + "1");
            bindView.box1.setImageResource(R.mipmap.ic_add_action);
            bindView.tvSecond1.setVisibility(View.INVISIBLE);
        } else if (view.getId() == bindView.box2.getId()) {
            KVManager.getInstance().remove(LoadMgr.getInstance().getTheme().theme() + "_action_" + type + "2");
            KVManager.getInstance().remove(LoadMgr.getInstance().getTheme().theme() + "_time_" + type + "2");
            bindView.box2.setImageResource(R.mipmap.ic_add_action);
            bindView.tvSecond2.setVisibility(View.INVISIBLE);
        } else if (view.getId() == bindView.box3.getId()) {
            KVManager.getInstance().remove(LoadMgr.getInstance().getTheme().theme() + "_action_" + type + "3");
            KVManager.getInstance().remove(LoadMgr.getInstance().getTheme().theme() + "_time_" + type + "3");
            bindView.box3.setImageResource(R.mipmap.ic_add_action);
            bindView.tvSecond3.setVisibility(View.INVISIBLE);
        }
        return true;
    }

}