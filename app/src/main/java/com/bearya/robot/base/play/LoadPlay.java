package com.bearya.robot.base.play;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LoadPlay {
    private final List<PlayData> playDataList = new ArrayList<>();

    public LoadPlay() {
    }

    public LoadPlay(PlayData... data) {
        Collections.addAll(playDataList, data);
    }

    public void addLoad(PlayData data){
        playDataList.add(data);
    }

    public PlayData getPlay() {
        if(!isComplete()) {
            return playDataList.remove(0);
        }else{
            return null;
        }
    }

    public boolean isComplete(){
        return playDataList.isEmpty();
    }

}
