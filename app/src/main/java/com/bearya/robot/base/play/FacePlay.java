package com.bearya.robot.base.play;

public class FacePlay {
    private final String face;
    private final FaceType faceType;
    private int time;

    private final int resId;

    public FacePlay(String face, FaceType faceType) {
        this.face = face;
        this.faceType = faceType;
        time = -1;
        resId = -1;
    }

    public FacePlay(int res, FaceType faceType) {
        this.resId = res;
        this.faceType = faceType;
        time = 50;
        face = null;
    }

    public FacePlay(String face, FaceType faceType, int time) {
        this.face = face;
        this.faceType = faceType;
        this.time = time;

        resId = -1;
    }

    public String getFace() {
        return face;
    }

    public FaceType getFaceType() {
        return faceType;
    }

    public int getResource(){ return resId;}

    public int getTime() {
        return time;
    }

}
