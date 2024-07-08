package com.bearya.robot.fairystory.walk.car;

import com.bearya.robot.base.load.BaseLoad;
import com.bearya.robot.base.load.ILoadMgr;
import com.bearya.robot.base.util.DebugUtil;
import com.bearya.robot.base.walk.LoadEntrance;
import com.bearya.robot.fairystory.walk.load.EndLoad;
import com.bearya.robot.fairystory.walk.load.EquipmentLoad;
import com.bearya.robot.fairystory.walk.subjects.AbsSubject;
import com.bearya.robot.fairystory.walk.themes.AbsTheme;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoadMgr implements ILoadMgr {

    private final Map<String, BaseLoad> loads = new HashMap<>();
    private final List<String> equipmentLoads = new ArrayList<>();//设备经过的装备地垫
    private final List<String> lostEquipmentLoads = new ArrayList<>();//到达终点还缺失的地垫
    private AbsTheme theme;
    private AbsSubject currentSubject;

    /**
     * 当前路况:包括小贝从哪进来从哪出去
     */
    private final LoadEntrance currentLoadEntrance = new LoadEntrance();

    private static LoadMgr instance;

    public static LoadMgr getInstance() {
        if (instance == null) {
            instance = new LoadMgr();
        }
        return instance;
    }

    private LoadMgr() {

    }

    public void setTheme(AbsTheme type) {
        theme = type;
        loads.clear();
        loads.putAll(type.loads());
    }

    public AbsTheme getTheme() {
        return theme;
    }

    public void setCurrentSubject(AbsSubject subject) {
        currentSubject = subject;
    }

    public List<AbsSubject> getSubjects() {
        return theme != null && theme.subjects().length > 0 ? Arrays.asList(theme.subjects()) : Collections.emptyList();
    }

    // 获取当前theme下的创想天地
    public AbsSubject getCurrentThemeDreamSubject() {
        return theme != null ? theme.dreamSubject() : null;
    }

    public AbsSubject getCurrentSubject() {
        return currentSubject;
    }

    public boolean inLoad(int oid) {
        return getLoad(oid) != null;
    }

    public BaseLoad getLoad(int oid) {
        Collection<BaseLoad> loadCollection = loads.values();
        for (BaseLoad load : loadCollection) {
            if (load.getOidSection().in(oid)) {
                return load;
            }
        }
        return null;
    }

    public BaseLoad getLoad(String name) {
        return loads.getOrDefault(name, null);
    }

    public void clear() {
        currentLoadEntrance.reset();
        equipmentLoads.clear();
    }

    public void release() {
        clear();
        loads.clear();
        theme = null;
        currentSubject = null;
    }

    public void addHistory(LoadEntrance newInstance) {
        if (newInstance.getLoad() instanceof EquipmentLoad) {
            EquipmentLoad equipmentLoad = (EquipmentLoad) newInstance.getLoad();
            equipmentLoads.add(equipmentLoad.getName());
        }
        DebugUtil.debug("添加路径记录:%s - %s", newInstance.getLoadName(), newInstance.getLoad().getClass().getSimpleName());
    }

    public LoadEntrance getCurrentLoadEntrance() {
        return currentLoadEntrance;
    }

    public List<String> getLostEquipmentLoadList(EndLoad endLoad) {

        EndLoad themeEndLoad = currentSubject.end();

        lostEquipmentLoads.clear();
        if (endLoad != themeEndLoad) {
            return null;
        }
        String[] eqLoads = themeEndLoad.getEquipmentLoads();
        for (String eName : eqLoads) {
            if (!equipmentLoads.contains(eName)) {
                lostEquipmentLoads.add(eName);
            }
        }
        return lostEquipmentLoads;
    }

}