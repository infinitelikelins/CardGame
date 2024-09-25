package com.bearya.robot.base.play;

public class FacePlay {
    private int faceId;
    private String face;
    private FaceType faceType;
    private int time = -1;
    private boolean repeat = false;

    public FacePlay(int face, FaceType faceType) {
        this.faceId = face;
        this.faceType = faceType;
    }

    public FacePlay(String face, FaceType faceType) {
        this.face = face;
        this.faceType = faceType;
    }

    public FacePlay(String face, FaceType faceType, int time) {
        this.face = face;
        this.faceType = faceType;
        this.time = time;
    }

    public FacePlay(String face, FaceType faceType, int time, boolean repeat) {
        this.face = face;
        this.faceType = faceType;
        this.time = time;
        this.repeat = repeat;
    }

    public int getFaceId() {
        return faceId;
    }

    public String getFace() {
        return face;
    }

    public FaceType getFaceType() {
        return faceType;
    }

    public int getTime() {
        return time;
    }

    public boolean isRepeat() {
        return repeat;
    }
}
