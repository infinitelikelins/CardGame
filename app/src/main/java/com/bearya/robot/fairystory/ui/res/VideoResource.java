package com.bearya.robot.fairystory.ui.res;

import android.os.Environment;

public interface VideoResource {

    String ROOT = Environment.getExternalStorageDirectory().getPath();

    String UNIVERSE_VIDEO_BASE_PATH = ROOT + "/fairy/universe/video/";

    String RocketUnderstand = UNIVERSE_VIDEO_BASE_PATH + "RocketUnderstand.mp4";
    String RocketPrinciple = UNIVERSE_VIDEO_BASE_PATH + "RocketPrinciple.mp4";
    String RocketLaunch = UNIVERSE_VIDEO_BASE_PATH + "RocketLaunch.mp4";
    String AstronautTrain = UNIVERSE_VIDEO_BASE_PATH + "AstronautTrain.mp4";
    String PlanetCharacteristics = UNIVERSE_VIDEO_BASE_PATH + "PlanetCharacteristics.mp4";
    String SpaceStationRole = UNIVERSE_VIDEO_BASE_PATH + "SpaceStationRole.mp4";
    String SpaceStationBuild = UNIVERSE_VIDEO_BASE_PATH + "SpaceStationBuild.mp4";
    String SpaceStationComposition = UNIVERSE_VIDEO_BASE_PATH + "SpaceStationComposition.mp4";
    String Planet = UNIVERSE_VIDEO_BASE_PATH + "Planet.mp4";
    String SpaceStationsLife = UNIVERSE_VIDEO_BASE_PATH + "SpaceStationsLife.mp4";
    String Astronaut = UNIVERSE_VIDEO_BASE_PATH + "Astronaut.mp4";
    String PlanetMotion = UNIVERSE_VIDEO_BASE_PATH + "PlanetMotion.mp4";

}