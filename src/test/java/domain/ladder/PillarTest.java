package domain.ladder;


import domain.maker.PillarMaker;
import dto.GameStartOption;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PillarTest {

    @Test
    public void 기둥에_연결된_다리의_location_값_리스트_가져오기() {
        GameStartOption gameStartOption = GameStartOption.of("pobi,honux,crong,jk", 3, "꽝,5000,꽝,3000");

        Pillar p = Pillar.of(PillarMaker.of().createBridgesInThisPillar(gameStartOption), 1);
        List<Integer> bridgesLocations = p.getBridgesLocations();
        System.out.println(bridgesLocations);
        assertEquals(true, bridgesLocations.size() <= 3 && bridgesLocations.size() >= 0);
    }

    @Test
    public void 기둥에_연결된_특정_방향의_다리의_location_값_리스트_가져오기() {

        GameStartOption gameStartOption = GameStartOption.of("pobi,honux,crong,jk", 3, "꽝,5000,꽝,3000");

        Pillar p = Pillar.of(PillarMaker.of().createBridgesInThisPillar(gameStartOption), 1);
        List<Integer> bridgesLocations = p.getBridgesDirectionLocation(LinkedType.LEFT);
        assertEquals(0, bridgesLocations.size());
    }

}