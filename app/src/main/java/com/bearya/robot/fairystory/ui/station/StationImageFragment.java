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
import com.google.android.material.tabs.TabLayout;

import java.util.List;
import java.util.Objects;

public class StationImageFragment extends Fragment {

    private FragmentStationImageBinding bindView;
    private List<Lib> libs;
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
        libs = LibRepository.getImageLibs();
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
        adapter.setOnItemLongClickListener((baseQuickAdapter, view12, position) -> {
            String image = Objects.requireNonNull(adapter.getItem(position)).getImage();
            new ImagePreviewDialog(requireActivity(), image).show();
            return true;
        });
        bindView.recyclerView.setAdapter(adapter);

        if (libs != null) {
            for (Lib imageLib : libs) {
                TabLayout.Tab tab = bindView.tabs.newTab().setText(imageLib.getName());
                bindView.tabs.addTab(tab);
                if (tab.isSelected()) {
                    adapter.setNewData(imageLib.getItems());
                }
            }

            bindView.tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    for (Lib imageLibs : libs) {
                        if (TextUtils.equals(tab.getText(), imageLibs.getName())) {
                            adapter.setNewData(imageLibs.getItems());
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