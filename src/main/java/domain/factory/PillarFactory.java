package domain.factory;

import domain.ladder.Bridge;
import domain.ladder.Pillar;
import domain.maker.PillarMaker;
import dto.GameStartOption;

import java.util.List;

public class PillarFactory {

    public static final int MINIMUM_PILLAR_NUM = 0;

    public Pillar createFirstPillar (GameStartOption gameStartOption) {

        List<Bridge> bridges = new PillarMaker().createBridgesInThisPillar(gameStartOption);
        Integer pillarNum = MINIMUM_PILLAR_NUM;

        return new Pillar(bridges, pillarNum);
    }

    public Pillar createNotFirstPillar (GameStartOption gameStartOption, Pillar previousPillar) {

        List<Bridge> bridges = new PillarMaker().createBridgesInThisPillar(gameStartOption, previousPillar);
        Integer pillarNum = nowPillarNum(previousPillar);

        return new Pillar(bridges, pillarNum);

    }

    private Integer nowPillarNum(Pillar previousPillar) {
        return previousPillar.getPillarNum() + 1;
    }

}
