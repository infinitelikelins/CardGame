package com.bearya.robot.fairystory.walk.themes;

import com.bearya.robot.R;
import com.bearya.robot.base.load.BaseLoad;
import com.bearya.robot.fairystory.ui.res.MusicResource;
import com.bearya.robot.fairystory.walk.load.StartLoad;
import com.bearya.robot.fairystory.walk.load.festival.DoubleNinthCustomLoad;
import com.bearya.robot.fairystory.walk.load.festival.DoubleNinthEndLoad;
import com.bearya.robot.fairystory.walk.load.festival.DoubleNinthFoodsLoad;
import com.bearya.robot.fairystory.walk.load.festival.DoubleNinthGameLoad;
import com.bearya.robot.fairystory.walk.load.festival.DoubleNinthKnowledgeLoad;
import com.bearya.robot.fairystory.walk.load.festival.DragonBoatCustomLoad;
import com.bearya.robot.fairystory.walk.load.festival.DragonBoatEndLoad;
import com.bearya.robot.fairystory.walk.load.festival.DragonBoatGardenPartyLoad;
import com.bearya.robot.fairystory.walk.load.festival.DragonBoatKnowledgeLoad;
import com.bearya.robot.fairystory.walk.load.festival.FestivalEndLoad;
import com.bearya.robot.fairystory.walk.load.festival.FireworksLoad;
import com.bearya.robot.fairystory.walk.load.festival.LanternCustomLoad;
import com.bearya.robot.fairystory.walk.load.festival.LanternEndLoad;
import com.bearya.robot.fairystory.walk.load.festival.LanternFoodsLoad;
import com.bearya.robot.fairystory.walk.load.festival.LanternLampLoad;
import com.bearya.robot.fairystory.walk.load.festival.MidAutumnCustomLoad;
import com.bearya.robot.fairystory.walk.load.festival.MidAutumnEndLoad;
import com.bearya.robot.fairystory.walk.load.festival.MidAutumnGardenPartyLoad;
import com.bearya.robot.fairystory.walk.load.festival.MidAutumnKnowledgeLoad;
import com.bearya.robot.fairystory.walk.load.festival.MidAutumnMoonLoad;
import com.bearya.robot.fairystory.walk.load.festival.SpringDragonLoad;
import com.bearya.robot.fairystory.walk.load.festival.SpringEndLoad;
import com.bearya.robot.fairystory.walk.load.festival.SpringFoodsLoad;
import com.bearya.robot.fairystory.walk.load.festival.SpringKnowledgeLoad;
import com.bearya.robot.fairystory.walk.load.festival.TombSweepCustomLoad;
import com.bearya.robot.fairystory.walk.load.festival.TombSweepEndLoad;
import com.bearya.robot.fairystory.walk.load.festival.TombSweepKiteLoad;
import com.bearya.robot.fairystory.walk.load.festival.TombSweepKnowledgeLoad;
import com.bearya.robot.fairystory.walk.load.festival.TombSweepRiceBallLoad;
import com.bearya.robot.fairystory.walk.load.festival.WinterCustomLoad;
import com.bearya.robot.fairystory.walk.load.festival.WinterEndLoad;
import com.bearya.robot.fairystory.walk.load.festival.WinterGameLoad;
import com.bearya.robot.fairystory.walk.load.festival.WinterKnowledgeLoad;
import com.bearya.robot.fairystory.walk.load.station.StationBlueLoad;
import com.bearya.robot.fairystory.walk.load.station.StationGreenLoad;
import com.bearya.robot.fairystory.walk.load.station.StationPinkLoad;
import com.bearya.robot.fairystory.walk.load.station.StationPurpleLoad;
import com.bearya.robot.fairystory.walk.load.station.StationRedLoad;
import com.bearya.robot.fairystory.walk.load.station.StationYellowLoad;
import com.bearya.robot.fairystory.walk.subjects.AbsSubject;
import com.bearya.robot.fairystory.walk.subjects.DoubleNinthSubject;
import com.bearya.robot.fairystory.walk.subjects.DragonBoatSubject;
import com.bearya.robot.fairystory.walk.subjects.LanternSubject;
import com.bearya.robot.fairystory.walk.subjects.MidAutumnSubject;
import com.bearya.robot.fairystory.walk.subjects.SpringSubject;
import com.bearya.robot.fairystory.walk.subjects.TombSweepSubject;
import com.bearya.robot.fairystory.walk.subjects.WinterSolsticeSubject;

import java.util.HashMap;
import java.util.Map;

public class FestivalTheme implements AbsTheme {

    public static final String FESTIVAL = "Festival";
    public static final String KEY = "U2FsdGVkX18TEmRYklrNGUoUxio407CIEYLxCM+p7CU=";

    @Override
    public String theme() {
        return FESTIVAL;
    }

    @Override
    public int res() {
        return R.mipmap.theme_festival;
    }

    @Override
    public AbsSubject[] subjects() {
        return new AbsSubject[]{
                new SpringSubject(),
                new LanternSubject(),
                new TombSweepSubject(),
                new DragonBoatSubject(),
                new DoubleNinthSubject(),
                new MidAutumnSubject(),
                new WinterSolsticeSubject()
        };
    }

    @Override
    public Map<String, BaseLoad> loads() {
        Map<String, BaseLoad> loads = new HashMap<>();

        loads.put(StartLoad.NAME, new StartLoad());
        loads.put(FireworksLoad.NAME, new FireworksLoad());
        loads.put(FestivalEndLoad.NAME, new FestivalEndLoad());

        //春节
        loads.put(SpringKnowledgeLoad.NAME, new SpringKnowledgeLoad());
        loads.put(SpringFoodsLoad.NAME, new SpringFoodsLoad());
        loads.put(SpringDragonLoad.NAME, new SpringDragonLoad());
        loads.put(SpringEndLoad.NAME, new SpringEndLoad());
        //元宵节
        loads.put(LanternFoodsLoad.NAME, new LanternFoodsLoad());
        loads.put(LanternCustomLoad.NAME, new LanternCustomLoad());
        loads.put(LanternLampLoad.NAME, new LanternLampLoad());
        loads.put(LanternEndLoad.NAME, new LanternEndLoad());
        //清明节
        loads.put(TombSweepKiteLoad.NAME, new TombSweepKiteLoad());
        loads.put(TombSweepRiceBallLoad.NAME, new TombSweepRiceBallLoad());
        loads.put(TombSweepKnowledgeLoad.NAME, new TombSweepKnowledgeLoad());
        loads.put(TombSweepCustomLoad.NAME, new TombSweepCustomLoad());
        loads.put(TombSweepEndLoad.NAME, new TombSweepEndLoad());
        //端午节
        loads.put(DragonBoatGardenPartyLoad.NAME, new DragonBoatGardenPartyLoad());
        loads.put(DragonBoatCustomLoad.NAME, new DragonBoatCustomLoad());
        loads.put(DragonBoatKnowledgeLoad.NAME, new DragonBoatKnowledgeLoad());
        loads.put(DragonBoatEndLoad.NAME, new DragonBoatEndLoad());
        //重阳节
        loads.put(DoubleNinthKnowledgeLoad.NAME, new DoubleNinthKnowledgeLoad());
        loads.put(DoubleNinthCustomLoad.NAME, new DoubleNinthCustomLoad());
        loads.put(DoubleNinthFoodsLoad.NAME, new DoubleNinthFoodsLoad());
        loads.put(DoubleNinthGameLoad.NAME, new DoubleNinthGameLoad());
        loads.put(DoubleNinthEndLoad.NAME, new DoubleNinthEndLoad());
        //中秋节
        loads.put(MidAutumnKnowledgeLoad.NAME, new MidAutumnKnowledgeLoad());
        loads.put(MidAutumnMoonLoad.NAME, new MidAutumnMoonLoad());
        loads.put(MidAutumnCustomLoad.NAME, new MidAutumnCustomLoad());
        loads.put(MidAutumnGardenPartyLoad.NAME, new MidAutumnGardenPartyLoad());
        loads.put(MidAutumnEndLoad.NAME, new MidAutumnEndLoad());
        //冬至
        loads.put(WinterKnowledgeLoad.NAME, new WinterKnowledgeLoad());
        loads.put(WinterGameLoad.NAME, new WinterGameLoad());
        loads.put(WinterCustomLoad.NAME, new WinterCustomLoad());
        loads.put(WinterEndLoad.NAME, new WinterEndLoad());
        //小站
        loads.put(StationBlueLoad.NAME, new StationBlueLoad());
        loads.put(StationGreenLoad.NAME, new StationGreenLoad());
        loads.put(StationPinkLoad.NAME, new StationPinkLoad());
        loads.put(StationPurpleLoad.NAME, new StationPurpleLoad());
        loads.put(StationRedLoad.NAME, new StationRedLoad());
        loads.put(StationYellowLoad.NAME, new StationYellowLoad());

        return loads;
    }

    @Override
    public AbsSubject dreamSubject() {
        return null;
    }

    @Override
    public int backgroundPath() {
        return R.mipmap.background_festival;
    }

    @Override
    public int stationEnterImage() {
        return 0;
    }

    @Override
    public String welcomeSound() {
        return MusicResource.WELCOME_TO_FESTIVAL;
    }

    @Override
    public String themeNameSound() {
        return MusicResource.FESTIVAL;
    }

    @Override
    public String key() {
        return KEY;
    }

}
