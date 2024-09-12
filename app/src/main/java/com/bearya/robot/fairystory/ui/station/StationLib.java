package com.bearya.robot.fairystory.ui.station;

import com.bearya.robot.base.util.FileUtil;
import com.bearya.robot.fairystory.ui.res.MusicResource;
import com.bearya.robot.fairystory.ui.res.PictureResource;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class StationLib {
    Libs imageLibs;
    Libs soundLibs;

    public StationLib(Libs imageLibs, Libs soundLibs) {
        this.imageLibs = imageLibs;
        this.soundLibs = soundLibs;
    }

    public static StationLib newInstance(String filePath) {
        try {
            String json = FileUtil.stringFromSDCard(filePath);
            JSONObject root = new JSONObject(json);
            JSONArray jsonImageLibs = root.getJSONArray("image_libs");
            Libs imageLibs = new Libs();

            for (int i = 0; i < jsonImageLibs.length(); i++) {
                JSONObject imageLibJson = jsonImageLibs.getJSONObject(i);
                imageLibs.addLib(parseImageLib(imageLibJson));
            }
            Libs soundLibs = new Libs();
            JSONArray jsonSoundLibs = root.getJSONArray("sound_libs");
            for (int i = 0; i < jsonSoundLibs.length(); i++) {
                JSONObject soundLibJson = jsonSoundLibs.getJSONObject(i);
                soundLibs.addLib(parseSoundLib(soundLibJson));
            }
            return new StationLib(imageLibs, soundLibs);
        } catch (Exception e) {
            return null;
        }
    }

    private static Lib parseImageLib(JSONObject json) throws JSONException {
        Lib lib = new Lib();
        lib.name = json.optString("name");
        String imageType = json.optString("imageType");
        String imageName = json.optString("imageName");
        JSONArray itemArr = json.optJSONArray("items");
        for (int i = 0; i < itemArr.length(); i++) {
            JSONObject itemJson = itemArr.getJSONObject(i);
            LibItem imageItem = new LibItem();
            imageItem.setName(itemJson.optString("name"));
            imageItem.setType(imageType);
            if (imageType.equals("res")) {
                imageItem.setImage(PictureResource.BASE_PATH + imageName + itemJson.optString("index") + ".webp");
            } else if ("lottie".equals(imageType)) {
                imageItem.setImage(PictureResource.BASE_PATH + imageName + itemJson.optString("image") + ".webp");
            }
            lib.items.add(imageItem);
        }
        return lib;
    }

    private static Lib parseSoundLib(JSONObject json) throws JSONException {
        Lib lib = new Lib();
        lib.name = json.optString("name");
        String soundName = json.optString("soundName");
        String imageType = json.optString("imageType");
        String imageName = json.optString("imageName");
        JSONArray itemArr = json.optJSONArray("items");
        for (int i = 0; i < itemArr.length(); i++) {
            JSONObject itemJson = itemArr.getJSONObject(i);
            LibItem soundItem = new LibItem();
            if (imageType.equals("res")) {
                soundItem.setName(itemJson.optString("name"));
                soundItem.setImage(PictureResource.BASE_PATH + imageName + itemJson.optString("index") + ".webp");
            }
            soundItem.setMp3(MusicResource.BASE_PATH + soundName + itemJson.optString("index") + ".mp3");
            lib.items.add(soundItem);
        }
        return lib;
    }

}
