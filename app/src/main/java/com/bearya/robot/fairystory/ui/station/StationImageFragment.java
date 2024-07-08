package com.bearya.robot.fairystory.ui.station;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import com.bearya.robot.databinding.FragmentStationImageBinding;
import com.bearya.robot.fairystory.ui.adapter.ImageAdapter;
import com.bearya.robot.fairystory.ui.res.FileResource;
import com.bearya.robot.fairystory.walk.car.LoadMgr;
import com.google.android.material.tabs.TabLayout;

public class StationImageFragment extends Fragment {

    private FragmentStationImageBinding bindView;
    private String type;
    private ImageAdapter adapter;

    public static StationImageFragment newInstance(String type) {
        Bundle bundle = new Bundle();
        bundle.putString("type", type);
        StationImageFragment imageFragment = new StationImageFragment();
        imageFragment.setArguments(bundle);
        return imageFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        type = requireArguments().getString("type", "station_");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        bindView = FragmentStationImageBinding.inflate(inflater, container, false);
        return bindView.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindView.recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));

        adapter = new ImageAdapter(type);
        adapter.setOnItemClickListener((adapter1, view1, position) -> adapter.setSelectedIndex(position));
        bindView.recyclerView.setAdapter(adapter);

        String filePath = FileResource.BASE_PATH + LoadMgr.getInstance().getTheme().theme().toLowerCase() + "/station/station_libs.json";

        StationLib lib = StationLib.getLibsFromJSON(filePath);
        if (lib != null) {
            for (Lib imageLib : lib.imageLibs.libList) {
                TabLayout.Tab tab = bindView.tabs.newTab().setText(imageLib.name);
                bindView.tabs.addTab(tab);
                if (tab.isSelected()) {
                    adapter.setNewData(imageLib.items);
                }
            }

            bindView.tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    for (Lib imageLibs : lib.imageLibs.libList) {
                        if (TextUtils.equals(tab.getText(), imageLibs.name)) {
                            adapter.setNewData(imageLibs.items);
                            break;
                        }
                    }
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {

                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            });
        }
    }
}