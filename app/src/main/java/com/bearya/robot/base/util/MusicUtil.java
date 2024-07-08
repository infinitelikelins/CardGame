package com.bearya.robot.base.util;

import android.media.MediaPlayer;
import android.text.TextUtils;

import com.bearya.robot.base.BaseApplication;
import com.bearya.robot.base.musicplayer.LocalMusicPlayer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MusicUtil {

    private static LocalMusicPlayer localMusicPlayer = null;
    private static LocalMusicPlayer localMusicPlayerBg = null;

    public static void init() {
        localMusicPlayer = new LocalMusicPlayer(BaseApplication.getInstance());
        localMusicPlayerBg = new LocalMusicPlayer(BaseApplication.getInstance(), true);
    }

    private static List<String> audios = null;

    private static void playMusic() {
        if (audios != null && audios.size() > 0) {
            playMusic(audios.remove(0), mediaPlayer -> playMusic());
        }
    }

    public static void playMusic(String name) {
        playMusic(name, null);
    }

    public static void playMusic(String... names) {
        audios = new ArrayList<>(Arrays.asList(names));
        playMusic();
    }

    public static void playMusic(String name, final MediaPlayer.OnCompletionListener listener) {
        if (TextUtils.isEmpty(name)) {
            if (listener != null) {
                listener.onCompletion(null);
            }
            return;
        }
        try {
            DebugUtil.error("play tts:" + name);
            stopMusic();
            localMusicPlayer.setOnCompletionListener(listener);
            localMusicPlayer.setLoop(false);
            localMusicPlayer.play(!name.startsWith("/storage/emulated") ? String.format("android_asset/%s", name) : name);
        } catch (Exception e) {
            if (listener != null) {
                listener.onCompletion(null);
            }
        }
    }

    public static void stopMusic() {
        if (localMusicPlayer != null) {
            localMusicPlayer.stop();
        }
    }

    public static void playBGM(String name) {
        if (TextUtils.isEmpty(name)) {
            return;
        }
        try {
            localMusicPlayerBg.stop();
            localMusicPlayerBg.setLoop(true);
            localMusicPlayerBg.play(!name.startsWith("/storage/emulated") ? String.format("android_asset/%s", name) : name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void stopBGM() {
        localMusicPlayerBg.stop();
    }

    public static boolean isPlaying() {
        return (localMusicPlayer != null && localMusicPlayer.isPlaying()) ||
                (localMusicPlayerBg != null && localMusicPlayerBg.isPlaying());
    }
}