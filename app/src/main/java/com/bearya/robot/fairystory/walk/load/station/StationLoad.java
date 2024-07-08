package com.bearya.robot.fairystory.walk.load.station;

import android.text.TextUtils;
import android.util.ArrayMap;

import com.bearya.actionlib.utils.KVManager;
import com.bearya.robot.base.play.Director;
import com.bearya.robot.base.play.FacePlay;
import com.bearya.robot.base.play.FaceType;
import com.bearya.robot.base.play.LoadPlay;
import com.bearya.robot.base.play.PlayData;
import com.bearya.robot.base.play.TimeAction;
import com.bearya.robot.base.util.CodeUtils;
import com.bearya.robot.fairystory.walk.car.LoadMgr;
import com.bearya.robot.fairystory.walk.load.XLoad;
import com.bearya.robot.fairystory.walk.load.lock.DirectorPlayLock;

public abstract class StationLoad extends XLoad {

    public StationLoad(int startOid) {
        super(startOid);
        lock = new DirectorPlayLock();
    }

    @Override
    public void registerPlay() {
        LoadPlay newLoadPlay = new LoadPlay();
        PlayData playData = new PlayData();

        String theme = LoadMgr.getInstance().getTheme().theme();
        String video = KVManager.getInstance().getString(theme + "_video_" + getName());

        if (!TextUtils.isEmpty(video)) {
            playData.facePlay = new FacePlay(video, FaceType.Video);
        } else {
            String face = KVManager.getInstance().getString(theme + "_image_" + getName());
            String photo = KVManager.getInstance().getString(theme + "_photo_" + getName());
            if (!TextUtils.isEmpty(face)) {
                String lottie = face.substring(face.lastIndexOf("/") + 1, face.lastIndexOf(".webp"));
                if (CodeUtils.containEmotion(lottie))
                    playData.facePlay = new FacePlay(lottie, FaceType.Lottie);
                else
                    playData.facePlay = new FacePlay(face, FaceType.Image);
            } else if (!TextUtils.isEmpty(photo)) {
                playData.facePlay = new FacePlay(photo, FaceType.Image);
            }

            String sound = KVManager.getInstance().getString(theme + "_sound_" + getName());
            String record = KVManager.getInstance().getString(theme + "_record_" + getName());
            if (!TextUtils.isEmpty(sound)) {
                playData.sound = sound;
            } else if (!TextUtils.isEmpty(record)) {
                playData.sound = record;
            }
        }

        int action1 = KVManager.getInstance().getInt(theme + "_action_" + getName() + "1", 0);
        if (action1 > 0) {
            if (playData.actions == null) {
                playData.actions = new ArrayMap<>();
            }
            playData.actions.put(1, new TimeAction(action1, 3));
        }

        int action2 = KVManager.getInstance().getInt(theme + "_action_" + getName() + "2", 0);
        if (action2 > 0) {
            if (playData.actions == null) {
                playData.actions = new ArrayMap<>();
            }
            playData.actions.put(2, new TimeAction(action2, 3));
        }

        int action3 = KVManager.getInstance().getInt(theme + "_action_" + getName() + "3", 0);
        if (action3 > 0) {
            if (playData.actions == null) {
                playData.actions = new ArrayMap<>();
            }
            playData.actions.put(3, new TimeAction(action3, 3));
        }

        if (!playData.isEmpty()) {
            newLoadPlay.addLoad(playData);
        }
        Director.getInstance().register(ON_NEW_LOAD, newLoadPlay);
    }

}