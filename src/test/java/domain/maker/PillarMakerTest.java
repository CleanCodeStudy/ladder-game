package domain.maker;

import domain.factory.PillarFactoryTest;
import domain.ladder.Bridge;
import domain.ladder.LinkedType;
import domain.ladder.Pillar;
import dto.GameStartOption;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PillarMakerTest {

    @Test
    public void 자동으로_오른쪽_기둥과_연결된_다리리스트_만들기() {
        GameStartOption gameStartOption = new GameStartOption("pobi,honux,crong,jk", 3);
        List<Bridge> bridges = PillarMaker.of().createBridgesInThisPillar(gameStartOption);
        assertEquals(true, bridges.size() <= 3);
    }

    @Test
    public void 첫번째_기둥_bridge_리스트_만들기() {
        GameStartOption gameStartOption = new GameStartOption("pobi,honux,crong,jk", 3);
        List<Bridge> bridges = PillarMaker.of().createBridgesInThisPillar(gameStartOption);

        Pillar p = Pillar.of(bridges, 0);

        System.out.println(p.getBridgesLocations());

        assertEquals(p.getBridgesDirectionLocation(LinkedType.RIGHT), p.getBridgesLocations());
        assertEquals(0, p.getBridgesDirectionLocation(LinkedType.LEFT).size());
    }

    @Test
    public void 두번째_기둥_bridge_리스트_만들기() {
        GameStartOption gameStartOption = new GameStartOption("pobi,honux,crong,jk", 10);

        List<Bridge> bridges = PillarMaker.of().createBridgesInThisPillar(gameStartOption);
        Pillar p = Pillar.of(bridges, 0);

        List<Bridge> bridges1 = PillarMaker.of().createBridgesInThisPillar(gameStartOption, p);
        Pillar p1 = Pillar.of(bridges1, 1);

        List<Integer> p1LeftBridgesLocation = p1.getBridgesDirectionLocation(LinkedType.LEFT);
        List<Integer> p1RightBridgesLocation = p1.getBridgesDirectionLocation(LinkedType.RIGHT);
        List<Integer> pRightBridgesLocation = p.getBridgesDirectionLocation(LinkedType.RIGHT);

        System.out.println("P RIGHT" + pRightBridgesLocation);
        System.out.println("p1 LEFT" + p1LeftBridgesLocation);
        System.out.println("p1 RIGHT" + p1RightBridgesLocation);

        assertEquals(p.getBridgesLocations(), p1LeftBridgesLocation);
        assertEquals(pRightBridgesLocation, p1LeftBridgesLocation);
        assertEquals(false, p1RightBridgesLocation.contains(p1LeftBridgesLocation));
    }

    @Test
    public void 마지막_기둥_bridge_리스트_만들기() {
        GameStartOption gameStartOption = new GameStartOption("pobi,honux,crong,jk", 10);

        List<Bridge> bridges = PillarMaker.of().createBridgesInThisPillar(gameStartOption);
        Pillar p = Pillar.of(bridges, 0);

        List<Bridge> bridges1 = PillarMaker.of().createBridgesInThisPillar(gameStartOption, p);
        Pillar p1 = Pillar.of(bridges1, 1);


        List<Bridge> bridges2 = PillarMaker.of().createBridgesInThisPillar(gameStartOption, p1);
        Pillar p2 = Pillar.of(bridges2, 2);

        List<Bridge> bridges3 = PillarMaker.of().createBridgesInThisPillar(gameStartOption, p2);
        Pillar p3 = Pillar.of(bridges3, 3);


        System.out.println("P RIGHT" + p.getBridgesDirectionLocation(LinkedType.RIGHT));
        System.out.println("p1 LEFT" + p1.getBridgesDirectionLocation(LinkedType.LEFT));
        System.out.println("p1 RIGHT" + p1.getBridgesDirectionLocation(LinkedType.RIGHT));
        System.out.println("p2 LEFT" + p2.getBridgesDirectionLocation(LinkedType.LEFT));
        System.out.println("p2 RIGHT" + p2.getBridgesDirectionLocation(LinkedType.RIGHT));
        System.out.println("p3 LEFT" + p3.getBridgesDirectionLocation(LinkedType.LEFT));

        assertEquals(p3.getBridgesLocations(), p3.getBridgesDirectionLocation(LinkedType.LEFT));
        assertEquals(0, p3.getBridgesDirectionLocation(LinkedType.RIGHT).size());
    }
}