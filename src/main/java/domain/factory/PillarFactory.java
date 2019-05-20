package domain.factory;

import domain.ladder.Bridge;
import domain.ladder.Pillar;
import domain.maker.PillarMaker;
import dto.GameStartOption;

import java.util.List;

public class PillarFactory {

    public static final int MINIMUM_PILLAR_NUM = 0;

    public Pillar createFirstPillar(GameStartOption gameStartOption) {

        List<Bridge> bridges = PillarMaker.of().createBridgesInThisPillar(gameStartOption);
        Integer pillarNum = MINIMUM_PILLAR_NUM;

        return Pillar.of(bridges, pillarNum);
    }

    public Pillar createNotFirstPillar(GameStartOption gameStartOption, Pillar previousPillar) {

        List<Bridge> bridges = PillarMaker.of().createBridgesInThisPillar(gameStartOption, previousPillar);
        Integer pillarNum = nowPillarNum(previousPillar);

        return Pillar.of(bridges, pillarNum);

    }

    private Integer nowPillarNum(Pillar previousPillar) {
        return previousPillar.getPillarNum() + 1;
    }

}
