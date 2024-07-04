package com.bearya.robot.fairystory.walk.themes;

import com.bearya.robot.base.load.BaseLoad;
import com.bearya.robot.fairystory.walk.load.StartLoad;
import com.bearya.robot.fairystory.walk.load.station.StationBlueLoad;
import com.bearya.robot.fairystory.walk.load.station.StationGreenLoad;
import com.bearya.robot.fairystory.walk.load.station.StationPinkLoad;
import com.bearya.robot.fairystory.walk.load.station.StationPurpleLoad;
import com.bearya.robot.fairystory.walk.load.station.StationRedLoad;
import com.bearya.robot.fairystory.walk.load.station.StationYellowLoad;
import com.bearya.robot.fairystory.walk.load.story.ArmorLoad;
import com.bearya.robot.fairystory.walk.load.story.BigMonsterLoad;
import com.bearya.robot.fairystory.walk.load.story.CannibalFlowerLoad;
import com.bearya.robot.fairystory.walk.load.story.CastleEndLoad;
import com.bearya.robot.fairystory.walk.load.story.CompassLoad;
import com.bearya.robot.fairystory.walk.load.story.CrocodileLakeLoad;
import com.bearya.robot.fairystory.walk.load.story.CrystalShoesLoad;
import com.bearya.robot.fairystory.walk.load.story.DanceSkirtLoad;
import com.bearya.robot.fairystory.walk.load.story.DragonEndLoad;
import com.bearya.robot.fairystory.walk.load.story.FatTonnyLoad;
import com.bearya.robot.fairystory.walk.load.story.GrasslandLoad;
import com.bearya.robot.fairystory.walk.load.story.IdeaEndLoad;
import com.bearya.robot.fairystory.walk.load.story.KeyLoad;
import com.bearya.robot.fairystory.walk.load.story.MineEndLoad;
import com.bearya.robot.fairystory.walk.load.story.NineTailedCatLoad;
import com.bearya.robot.fairystory.walk.load.story.PegasusLoad;
import com.bearya.robot.fairystory.walk.load.story.SpiderLoad;
import com.bearya.robot.fairystory.walk.load.story.SwordLoad;
import com.bearya.robot.fairystory.walk.load.story.TreasureMapLoad;
import com.bearya.robot.fairystory.walk.load.story.TreeDemonLoad;
import com.bearya.robot.fairystory.walk.load.story.VolcanicLoad;
import com.bearya.robot.fairystory.walk.load.story.WitchLoad;
import com.bearya.robot.fairystory.walk.load.story.ZombieLoad;
import com.bearya.robot.fairystory.walk.subjects.AbsSubject;
import com.bearya.robot.fairystory.walk.subjects.CastleSubject;
import com.bearya.robot.fairystory.walk.subjects.DragonSubject;
import com.bearya.robot.fairystory.walk.subjects.TreasureSubject;

import java.util.HashMap;
import java.util.Map;

public class StoryTheme implements AbsTheme {

    public static final String STORY = "Story";

    @Override
    public String theme() {
        return STORY;
    }

    @Override
    public int res() {
        return 0;
    }

    @Override
    public AbsSubject[] subjects() {
        return new AbsSubject[]{
                new CastleSubject(),
                new TreasureSubject(),
                new DragonSubject()
        };
    }

    @Override
    public Map<String, BaseLoad> loads() {
        Map<String, BaseLoad> loads = new HashMap<>();

        loads.put(StartLoad.NAME, new StartLoad());
        loads.put(GrasslandLoad.NAME, new GrasslandLoad());

        loads.put(MineEndLoad.NAME, new MineEndLoad());
        loads.put(DragonEndLoad.NAME, new DragonEndLoad());
        loads.put(CastleEndLoad.NAME, new CastleEndLoad());
        loads.put(IdeaEndLoad.NAME, new IdeaEndLoad());

        loads.put(CompassLoad.NAME, new CompassLoad());
        loads.put(TreasureMapLoad.NAME, new TreasureMapLoad());
        loads.put(KeyLoad.NAME, new KeyLoad());
        loads.put(PegasusLoad.NAME, new PegasusLoad());
        loads.put(ArmorLoad.NAME, new ArmorLoad());
        loads.put(SwordLoad.NAME, new SwordLoad());
        loads.put(FatTonnyLoad.NAME, new FatTonnyLoad());
        loads.put(DanceSkirtLoad.NAME, new DanceSkirtLoad());

        loads.put(VolcanicLoad.NAME, new VolcanicLoad());

        loads.put(WitchLoad.NAME, new WitchLoad());
        loads.put(CrystalShoesLoad.NAME, new CrystalShoesLoad());
        loads.put(CrocodileLakeLoad.NAME, new CrocodileLakeLoad());
        loads.put(ZombieLoad.NAME, new ZombieLoad());
        loads.put(SpiderLoad.NAME, new SpiderLoad());
        loads.put(NineTailedCatLoad.NAME, new NineTailedCatLoad());
        loads.put(BigMonsterLoad.NAME, new BigMonsterLoad());
        loads.put(TreeDemonLoad.NAME, new TreeDemonLoad());
        loads.put(CannibalFlowerLoad.NAME, new CannibalFlowerLoad());

        loads.put(StationBlueLoad.NAME, new StationBlueLoad());
        loads.put(StationGreenLoad.NAME, new StationGreenLoad());
        loads.put(StationPinkLoad.NAME, new StationPinkLoad());
        loads.put(StationPurpleLoad.NAME, new StationPurpleLoad());
        loads.put(StationRedLoad.NAME, new StationRedLoad());
        loads.put(StationYellowLoad.NAME, new StationYellowLoad());

        return loads;
    }
}
