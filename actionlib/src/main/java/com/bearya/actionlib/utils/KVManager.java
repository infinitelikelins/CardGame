package com.bearya.actionlib.utils;

import com.tencent.mmkv.MMKV;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class KVManager {
    private static KVManager instance = null;

    public static KVManager getInstance() {
        if (instance == null) {
            instance = new KVManager();
        }
        return instance;
    }

    private final MMKV mmkv;

    private KVManager() {
        mmkv = MMKV.defaultMMKV();
    }

    public KVManager put(Map<String, String> map) {
        Set<String> set = map.keySet();
        for (String key : set) {
            mmkv.encode(key, map.get(key));
        }
        return this;
    }

    public KVManager put(String key, Set<String> value) {
        mmkv.encode(key, value);
        return this;
    }

    public KVManager put(String key, String value) {
        mmkv.encode(key, value);
        return this;
    }

    public KVManager put(String key, boolean value) {
        mmkv.encode(key, value);
        return this;
    }

    public KVManager put(String key, long value) {
        mmkv.encode(key, value);
        return this;
    }

    public KVManager put(String key, int value) {
        mmkv.encode(key, value);
        return this;
    }

    public void remove(String key) {
        mmkv.removeValueForKey(key);
    }

    public String getString(String key) {
        return mmkv.decodeString(key, "");
    }

    public String getString(String key, String defaultValue) {
        return mmkv.decodeString(key, defaultValue);
    }

    public int getInt(String key, int defaultValue) {
        return mmkv.decodeInt(key, defaultValue);
    }

    public boolean getBoolean(String key) {
        return mmkv.decodeBool(key, false);
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        return mmkv.decodeBool(key, defaultValue);
    }

    public long getLong(String key) {
        return mmkv.getLong(key, 0L);
    }

    public Set<String> getStringSet(String key) {
        return mmkv.decodeStringSet(key, new HashSet<>());
    }

}