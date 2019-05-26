package domain.maker;

import domain.ladder.Bridge;
import domain.ladder.LinkedType;
import domain.ladder.Pillar;
import dto.GameStartOption;

import java.util.ArrayList;
import java.util.List;

import static util.RandomIntegerMaker.createRandomIntegers;
import static util.RandomIntegerMaker.createRandomIntegersWithRestriction;

public class PillarMaker {

    private PillarMaker(){}

    public static PillarMaker of(){
        return new PillarMaker();
    }

    private static final Integer LAST_PILLAR_CHECKING_NUM = 2;
    private List<Bridge> bridges = new ArrayList<>();

    public List<Bridge> createBridgesInThisPillar(GameStartOption gameStartOption, Pillar previousPillar) {
        createLeftOnlyBridges(previousPillar);
        if (!isLastPillar(gameStartOption, previousPillar))
            createRightOnlyBridges(gameStartOption.getLadderHeight(), previousPillar);
        return new ArrayList<>(bridges);
    }

    public List<Bridge> createBridgesInThisPillar(GameStartOption gameStartOption) {
        createRightOnlyBridges(gameStartOption.getLadderHeight());
        return new ArrayList<>(bridges);
    }

    private void createRightOnlyBridges(Integer ladderHeight) {
        createRandomIntegers(ladderHeight).stream()
                .forEach(b -> bridges.add(Bridge.createOneRightBridge(b)));
    }

    private void createRightOnlyBridges(Integer ladderHeight, Pillar previous) {
        List<Integer> previousLocations = previous.getBridgesDirectionLocation(LinkedType.RIGHT);
        createRandomIntegersWithRestriction(ladderHeight, previousLocations).stream()
                .forEach(b -> bridges.add(Bridge.createOneRightBridge(b)));
    }

    private void createLeftOnlyBridges(Pillar previous) {
        previous.getBridgesDirectionLocation(LinkedType.RIGHT).stream()
                .forEach(b -> bridges.add(Bridge.createOneLeftBridge(b)));
    }

    private boolean isLastPillar(GameStartOption gameStartOption, Pillar previousPillar) {
        return gameStartOption.getLadderWidth() - previousPillar.getPillarNum() == LAST_PILLAR_CHECKING_NUM;
    }

}
