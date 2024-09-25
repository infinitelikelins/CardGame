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

import com.bearya.robot.databinding.FragmentStationVideoBinding;
import com.bearya.robot.fairystory.ui.adapter.VideoAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.List;
import java.util.Objects;

public class StationVideoFragment extends Fragment {

    private FragmentStationVideoBinding bindView;

    private String type;
    private List<Lib> libs;

    public static StationVideoFragment newInstance(String type) {
        Bundle bundle = new Bundle();
        bundle.putString("type", type);
        StationVideoFragment fragment = new StationVideoFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        type = requireArguments().getString("type", "video_");
        libs = LibRepository.getVideoLibs();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        bindView = FragmentStationVideoBinding.inflate(inflater, container, false);
        return bindView.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindView.recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));

        VideoAdapter adapter = new VideoAdapter(type);
        adapter.setOnItemClickListener((adapter1, view1, position) -> adapter.setSelectedIndex(position));
        adapter.setOnItemLongClickListener((baseQuickAdapter, view12, position) -> {
            String video = Objects.requireNonNull(adapter.getItem(position)).getVideo();
            new VideoPreviewDialog(requireActivity(), video).show();
            return true;
        });
        bindView.recyclerView.setAdapter(adapter);

        if (libs != null) {
            for (Lib videoLib : libs) {
                TabLayout.Tab tab = bindView.tabs.newTab().setText(videoLib.getName());
                bindView.tabs.addTab(tab);
                if (tab.isSelected()) {
                    adapter.setNewData(videoLib.getItems());
                }
            }
            bindView.tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    for (Lib videoLib : libs) {
                        if (TextUtils.equals(tab.getText(), videoLib.getName())) {
                            adapter.setNewData(videoLib.getItems());
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
