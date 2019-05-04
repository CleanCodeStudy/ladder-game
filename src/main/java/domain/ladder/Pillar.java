package domain.ladder;


import dto.GameStartOption;

import java.util.List;
import java.util.stream.Collectors;

import static util.RandomIntegerMaker.createRandomIntegers;
import static util.RandomIntegerMaker.createRandomIntegersWithRestriction;


public class Pillar {
    public static final int MINIMUM_PILLAR_NUM = 0;
    private List<Bridge> bridges;
    private Integer pillarNum;

    public Pillar(GameStartOption gameStartOption, Pillar previousPillar) { //자동으로 다리생성
        pillarNum = nowPillarNum(previousPillar);
        bridges = createBridges(gameStartOption, previousPillar);
    }

    public Integer getPillarNum() {
        return pillarNum;
    }

    public List<Bridge> getBridges() {
        return bridges;
    }

    private Integer nowPillarNum(Pillar previousPillar) {
        if (previousPillar == null)
            return MINIMUM_PILLAR_NUM;
        return previousPillar.getPillarNum() + 1;
    }

    public List<Integer> getBridgesLocations() {
        return bridges.stream()
                .map(b -> b.getLocation())
                .collect(Collectors.toList());
    }

    public List<Integer> getBridgesDirectionLocation(LinkedType linkedType) {
        return bridges.stream()
                .filter(b -> b.getLinkPillarDirection() == linkedType)
                .map(bridge -> bridge.getLocation())
                .collect(Collectors.toList());
    }

    private List<Bridge> createBridges(GameStartOption gameStartOption, Pillar previousPillar) {
        if (isFirstPillar(previousPillar))
            return createRightBridges(createRandomIntegers(gameStartOption.getLadderHeight()));
        if (isLastPillar(gameStartOption, previousPillar))
            return createLeftBridges(previousPillar);
        return createLeftRightBridges(previousPillar, gameStartOption.getLadderHeight());
    }


    private boolean isLastPillar(GameStartOption gameStartOption, Pillar previousPillar) {
        if (gameStartOption.getLadderWidth() - previousPillar.getPillarNum() == 2)
            return true;
        return false;
    }

    private boolean isFirstPillar(Pillar previousPillar) {
        if (previousPillar == null)
            return true;
        return false;
    }

    private List<Bridge> createLeftRightBridges(Pillar previous, Integer height) {
        List<Integer> previousLocations = previous.getBridgesDirectionLocation(LinkedType.RIGHT);
        List<Bridge> nowPillarsBridges = createLeftBridges(previous);
        List<Integer> rightBridgeNumbers = createRandomIntegersWithRestriction(height, previousLocations);
        nowPillarsBridges.addAll(createRightBridges(rightBridgeNumbers));
        return nowPillarsBridges;
    }

    private List<Bridge> createRightBridges(List<Integer> locationsOfBridge) {
        return locationsOfBridge.stream()
                .map(b -> Bridge.createOneRightBridge(b))
                .collect(Collectors.toList());
    }


    private List<Bridge> createLeftBridges(Pillar previous) {
        List<Integer> locationsOfBridge = previous.getBridgesDirectionLocation(LinkedType.RIGHT);
        return locationsOfBridge.stream()
                .map(b -> Bridge.createOneLeftBridge(b))
                .collect(Collectors.toList());
    }
}