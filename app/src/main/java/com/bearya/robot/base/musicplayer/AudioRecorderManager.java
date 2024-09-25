package com.bearya.robot.base.musicplayer;

import android.media.MediaRecorder;

public class AudioRecorderManager {

    private MediaRecorder recorder;
    private OnRecordListener onRecordListener;
    private boolean isRecording = false;

    private static AudioRecorderManager mInstance;

    public static AudioRecorderManager getInstance() {
        if (mInstance == null) {
            mInstance = new AudioRecorderManager();
        }
        return mInstance;
    }

    private AudioRecorderManager() {

    }

    public boolean isRecording() {
        return isRecording;
    }

    public void startRecord(String filePath, String fileName, OnRecordListener onRecordListener) {
        this.onRecordListener = onRecordListener;
        try {
            if (recorder == null) {
                recorder = new MediaRecorder();
            }
            recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            recorder.setOutputFormat(MediaRecorder.OutputFormat.AMR_NB);
            recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
            recorder.setOutputFile(filePath + fileName);
            recorder.setAudioSamplingRate(44100);
            recorder.setAudioEncodingBitRate(192000);
            recorder.prepare();
            recorder.start();
            isRecording = true;
            if (onRecordListener != null) onRecordListener.onStart();
        } catch (Exception e) {
            recorder = null;
            if (onRecordListener != null) onRecordListener.onError(e);
        }
    }

    public void stopRecord() {
        try {
            if (recorder != null) {
                recorder.stop();
                recorder.release();
            }
        } catch (Exception e) {
            if (recorder != null) {
                recorder.reset();
                recorder.release();
            }
        }
        isRecording = false;
        recorder = null;
        if (onRecordListener != null) onRecordListener.onStop();
        onRecordListener = null;
    }

    public interface OnRecordListener {
        void onStart();

        void onStop();

        void onError(Exception e);
    }

    public void release() {
        mInstance = null;
    }

}