package com.bearya.robot.fairystory.walk.themes;

import com.bearya.robot.R;
import com.bearya.robot.base.load.BaseLoad;
import com.bearya.robot.fairystory.ui.res.MusicResource;
import com.bearya.robot.fairystory.walk.load.StartLoad;
import com.bearya.robot.fairystory.walk.load.station.StationBlueLoad;
import com.bearya.robot.fairystory.walk.load.station.StationGreenLoad;
import com.bearya.robot.fairystory.walk.load.station.StationPinkLoad;
import com.bearya.robot.fairystory.walk.load.station.StationPurpleLoad;
import com.bearya.robot.fairystory.walk.load.station.StationRedLoad;
import com.bearya.robot.fairystory.walk.load.station.StationYellowLoad;
import com.bearya.robot.fairystory.walk.load.universe.AstronautEndLoad;
import com.bearya.robot.fairystory.walk.load.universe.AstronautLifeLoad;
import com.bearya.robot.fairystory.walk.load.universe.AstronautLoad;
import com.bearya.robot.fairystory.walk.load.universe.AstronautTrainLoad;
import com.bearya.robot.fairystory.walk.load.universe.FreeEndLoad;
import com.bearya.robot.fairystory.walk.load.universe.PlanetCharacteristicsLoad;
import com.bearya.robot.fairystory.walk.load.universe.PlanetLoad;
import com.bearya.robot.fairystory.walk.load.universe.PlanetMotionLoad;
import com.bearya.robot.fairystory.walk.load.universe.PlanetSecretEndLoad;
import com.bearya.robot.fairystory.walk.load.universe.RocketEndLoad;
import com.bearya.robot.fairystory.walk.load.universe.RocketLaunchLoad;
import com.bearya.robot.fairystory.walk.load.universe.RocketPrincipleLoad;
import com.bearya.robot.fairystory.walk.load.universe.RocketUnderstandLoad;
import com.bearya.robot.fairystory.walk.load.universe.SkyLoad;
import com.bearya.robot.fairystory.walk.load.universe.SpaceStationBuildLoad;
import com.bearya.robot.fairystory.walk.load.universe.SpaceStationCompositionLoad;
import com.bearya.robot.fairystory.walk.load.universe.SpaceStationEndLoad;
import com.bearya.robot.fairystory.walk.load.universe.SpaceStationRoleLoad;
import com.bearya.robot.fairystory.walk.subjects.AbsSubject;
import com.bearya.robot.fairystory.walk.subjects.AstronautSubject;
import com.bearya.robot.fairystory.walk.subjects.PlanetSecretSubject;
import com.bearya.robot.fairystory.walk.subjects.SpaceStationSubject;
import com.bearya.robot.fairystory.walk.subjects.SpaceshipSubject;
import com.bearya.robot.fairystory.walk.subjects.UniverseDreamSubject;

import java.util.HashMap;
import java.util.Map;

public class UniverseTheme extends AbsTheme {

    @Override
    public String theme() {
        return "Universe";
    }

    @Override
    public int res() {
        return R.mipmap.theme_universe;
    }

    @Override
    public AbsSubject[] subjects() {
        return new AbsSubject[]{
                new PlanetSecretSubject(),
                new SpaceStationSubject(),
                new AstronautSubject(),
                new SpaceshipSubject()
        };
    }

    @Override
    public Map<String, BaseLoad> loads() {
        Map<String, BaseLoad> loads = new HashMap<>();

        loads.put(StartLoad.NAME, new StartLoad());
        loads.put(SkyLoad.NAME, new SkyLoad());

        loads.put(StationBlueLoad.NAME, new StationBlueLoad());
        loads.put(StationGreenLoad.NAME, new StationGreenLoad());
        loads.put(StationPinkLoad.NAME, new StationPinkLoad());
        loads.put(StationPurpleLoad.NAME, new StationPurpleLoad());
        loads.put(StationRedLoad.NAME, new StationRedLoad());
        loads.put(StationYellowLoad.NAME, new StationYellowLoad());

        loads.put(RocketPrincipleLoad.NAME, new RocketPrincipleLoad());
        loads.put(RocketLaunchLoad.NAME, new RocketLaunchLoad());
        loads.put(RocketUnderstandLoad.NAME, new RocketUnderstandLoad());
        loads.put(AstronautTrainLoad.NAME, new AstronautTrainLoad());
        loads.put(PlanetCharacteristicsLoad.NAME, new PlanetCharacteristicsLoad());
        loads.put(SpaceStationRoleLoad.NAME, new SpaceStationRoleLoad());
        loads.put(SpaceStationBuildLoad.NAME, new SpaceStationBuildLoad());
        loads.put(SpaceStationCompositionLoad.NAME, new SpaceStationCompositionLoad());
        loads.put(PlanetLoad.NAME, new PlanetLoad());
        loads.put(AstronautLifeLoad.NAME, new AstronautLifeLoad());
        loads.put(AstronautLoad.NAME, new AstronautLoad());
        loads.put(PlanetMotionLoad.NAME, new PlanetMotionLoad());

        loads.put(FreeEndLoad.NAME, new FreeEndLoad());
        loads.put(SpaceStationEndLoad.NAME, new SpaceStationEndLoad());
        loads.put(PlanetSecretEndLoad.NAME, new PlanetSecretEndLoad());
        loads.put(RocketEndLoad.NAME, new RocketEndLoad());
        loads.put(AstronautEndLoad.NAME, new AstronautEndLoad());

        return loads;
    }

    @Override
    public AbsSubject dreamSubject() {
        return new UniverseDreamSubject();
    }

    @Override
    public int backgroundPath() {
        return R.mipmap.background_universe;
    }

    @Override
    public int stationEnterImage() {
        return R.mipmap.stations_universe;
    }

    @Override
    public String welcomeSound() {
        return MusicResource.WELCOME_TO_UNIVERSE;
    }

    @Override
    public String themeNameSound() {
        return MusicResource.UNIVERSE;
    }

}