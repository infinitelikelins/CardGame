package com.bearya.robot.base.play;

import android.text.TextUtils;

import java.util.List;

public class PlayData {
    public static final int ONLY_SOUND = 1;
    public static final int ONLY_VIDEO = 2;
    public static final int ONLY_ACTION = 4;
    public static final int ONLY_IMAGE = 8;
    public static final int ONLY_FRAME = 16;

    private final String sound;
    private final FacePlay facePlay;
    private final List<TimeAction> actions;

    private int completeCondition;
    private int alreadyCompleteCondition;

    public PlayData() {
        this(null, null);
    }

    public PlayData(String sound) {
        this(sound, null);
    }

    public PlayData(FacePlay facePlay) {
        this(null, facePlay);
    }

    public PlayData(String sound, FacePlay facePlay) {
        this(sound, facePlay, null);
    }

    public PlayData(String sound, FacePlay facePlay, List<TimeAction> actions) {
        this.sound = sound;
        this.facePlay = facePlay;
        this.actions = actions;

        countCompleteCondition();
    }

    private void countCompleteCondition() {
        alreadyCompleteCondition = 0;
        completeCondition = 0;
        if (!TextUtils.isEmpty(sound)) {
            completeCondition += ONLY_SOUND;
        }
        if (facePlay != null) {
            if (facePlay.getFaceType() == FaceType.Video) {
                completeCondition += ONLY_VIDEO;
            } else if (facePlay.getFaceType() == FaceType.Image || facePlay.getFaceType() == FaceType.Lottie || facePlay.getFaceType() == FaceType.ANIMATION) {
                completeCondition += ONLY_IMAGE;
            } else if (facePlay.getFaceType() == FaceType.Frame) {
                completeCondition += ONLY_FRAME;
            }
        }
        if (actions != null && !actions.isEmpty()) {
            completeCondition += ONLY_ACTION;
        }
    }

    public void complete(int condition) {
        alreadyCompleteCondition += condition;
    }

    public boolean isComplete() {
        return alreadyCompleteCondition >= completeCondition;
    }

    public String getSound() {
        return sound;
    }

    public FacePlay getFacePlay() {
        return facePlay;
    }

    public List<TimeAction> getTimeActions() {
        return actions;
    }

    public boolean containFace() {
        return facePlay != null && !TextUtils.isEmpty(facePlay.getFace());
    }

    public boolean containMp3() {
        return !TextUtils.isEmpty(sound);
    }

    public boolean containAction() {
        return actions != null && !actions.isEmpty();
    }

    public boolean isEmpty() {
        return !containFace() && !containMp3() && !containAction();
    }

}