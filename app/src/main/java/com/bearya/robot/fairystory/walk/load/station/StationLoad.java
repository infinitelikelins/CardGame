package com.bearya.robot.fairystory.walk.load.station;

import android.text.TextUtils;

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

import java.util.LinkedList;
import java.util.List;

public abstract class StationLoad extends XLoad {

    public StationLoad(int startOid) {
        super(startOid);
        lock = new DirectorPlayLock();
    }

    @Override
    public void registerPlay() {

        FacePlay facePlay = null;
        String mp3 = null;
        List<TimeAction> actions = null;

        String theme = LoadMgr.getInstance().getTheme().theme();
        String video = KVManager.getInstance().getString(theme + "_video_" + getName());
        if (!TextUtils.isEmpty(video)) {
            facePlay = new FacePlay(video, FaceType.Video);
        } else {
            String face = KVManager.getInstance().getString(theme + "_image_" + getName());
            String photo = KVManager.getInstance().getString(theme + "_photo_" + getName());
            if (!TextUtils.isEmpty(face)) {
                String lottie = face.substring(face.lastIndexOf("/") + 1, face.lastIndexOf(".webp"));
                if (CodeUtils.containEmotion(lottie))
                    facePlay = new FacePlay(lottie, FaceType.Lottie);
                else
                    facePlay = new FacePlay(face, FaceType.Image);
            } else if (!TextUtils.isEmpty(photo)) {
                facePlay = new FacePlay(photo, FaceType.Image);
            }
            String sound = KVManager.getInstance().getString(theme + "_sound_" + getName());
            String record = KVManager.getInstance().getString(theme + "_record_" + getName());
            mp3 = !TextUtils.isEmpty(sound) ? sound : !TextUtils.isEmpty(record) ? record : null;
        }

        int action1 = KVManager.getInstance().getInt(theme + "_action_" + getName() + "1", 0);
        int action2 = KVManager.getInstance().getInt(theme + "_action_" + getName() + "2", 0);
        int action3 = KVManager.getInstance().getInt(theme + "_action_" + getName() + "3", 0);

        int time1 = KVManager.getInstance().getInt(LoadMgr.getInstance().getTheme().theme() + "_time_" + getName() + "1", 3000);
        int time2 = KVManager.getInstance().getInt(LoadMgr.getInstance().getTheme().theme() + "_time_" + getName() + "2", 3000);
        int time3 = KVManager.getInstance().getInt(LoadMgr.getInstance().getTheme().theme() + "_time_" + getName() + "3", 3000);

        if ((action1 + action2 + action3) > 0) {
            actions = new LinkedList<>();
            if (action1 > 0) actions.add(new TimeAction(action1, time1));
            if (action2 > 0) actions.add(new TimeAction(action2, time2));
            if (action3 > 0) actions.add(new TimeAction(action3, time3));
        }

        LoadPlay newLoadPlay = new LoadPlay(new PlayData(mp3, facePlay, actions));

        Director.getInstance().register(ON_NEW_LOAD, newLoadPlay);
    }

}