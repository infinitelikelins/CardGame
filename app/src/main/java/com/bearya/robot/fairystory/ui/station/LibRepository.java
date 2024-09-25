package com.bearya.robot.fairystory.ui.station;

import com.bearya.robot.fairystory.ui.res.FileResource;
import com.bearya.robot.fairystory.walk.car.LoadMgr;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

public class LibRepository {

    public static List<Lib> getImageLibs() {
        String filePath = FileResource.BASE_PATH + LoadMgr.getInstance().getTheme().theme().toLowerCase() + "/station/image.json";
        try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)))) {
            Type type = new TypeToken<List<Lib>>() {
            }.getType();
            return new Gson().fromJson(in, type);
        } catch (Exception e) {
            return null;
        }
    }

    public static List<Lib> getSoundLibs() {
        String filePath = FileResource.BASE_PATH + LoadMgr.getInstance().getTheme().theme().toLowerCase() + "/station/sound.json";
        try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)))) {
            Type type = new TypeToken<List<Lib>>() {
            }.getType();
            return new Gson().fromJson(in, type);
        } catch (Exception e) {
            return null;
        }
    }

    public static List<Lib> getVideoLibs() {
        String filePath = FileResource.BASE_PATH + LoadMgr.getInstance().getTheme().theme().toLowerCase() + "/station/video.json";
        try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)))) {
            Type type = new TypeToken<List<Lib>>() {
            }.getType();
            return new Gson().fromJson(in, type);
        } catch (Exception e) {
            return null;
        }
    }

}