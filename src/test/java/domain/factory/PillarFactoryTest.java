package domain.factory;

import domain.ladder.Pillar;
import dto.GameStartOption;
import org.junit.Test;

import static org.junit.Assert.*;

public class PillarFactoryTest {


    @Test
    public void 첫번째기둥_넘버만들기() {
        GameStartOption gameStartOption = new GameStartOption("pobi,honux,crong,jk", 3);
        PillarFactory pillarFactory = new PillarFactory();
        Pillar p = pillarFactory.createFirstPillar(gameStartOption);
        assertEquals((Integer) 0, p.getPillarNum());
    }

    @Test
    public void 가운데기둥_넘버만들기() {
        GameStartOption gameStartOption = new GameStartOption("pobi,honux,crong,jk", 3);
        PillarFactory pillarFactory = new PillarFactory();
        Pillar p = pillarFactory.createFirstPillar(gameStartOption);
        Pillar p1 = pillarFactory.createNotFirstPillar(gameStartOption, p);

        assertEquals((Integer) 1, p1.getPillarNum());
    }

    @Test
    public void 마지막기둥_넘버만들기() {
        GameStartOption gameStartOption = new GameStartOption("pobi,honux,crong,jk", 3);
        PillarFactory pillarFactory = new PillarFactory();
        Pillar p = pillarFactory.createFirstPillar(gameStartOption);
        Pillar p1 = pillarFactory.createNotFirstPillar(gameStartOption, p);
        Pillar p2 = pillarFactory.createNotFirstPillar(gameStartOption, p1);
        Pillar p3 = pillarFactory.createNotFirstPillar(gameStartOption, p2);

        assertEquals((Integer) 3, p3.getPillarNum());
    }

    @Test
    public void 이전기둥확인해서_넘버만들기() {
        GameStartOption gameStartOption = new GameStartOption("pobi,honux,crong,jk", 3);
        PillarFactory pillarFactory = new PillarFactory();
        Pillar p = pillarFactory.createFirstPillar(gameStartOption);
        Pillar p1 = pillarFactory.createNotFirstPillar(gameStartOption, p);

        assertEquals((Integer) 1, p1.getPillarNum());
    }

}