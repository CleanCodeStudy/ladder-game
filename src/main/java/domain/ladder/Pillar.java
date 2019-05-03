package domain.ladder;

import data.InputData;

import java.util.List;
import java.util.stream.Collectors;

import static util.Util.createRandomIntegers;
import static util.Util.createRandomIntegersWithRestriction;

public class Pillar {
    private List<Bridge> bridges;
    private Integer pillarNum;

    public Pillar(InputData inputData, Pillar previousPillar) { //자동으로 다리생성
        pillarNum = nowPillarNum(previousPillar);
        bridges = createBridges(inputData, previousPillar);
    }

    public Integer getPillarNum() {
        return pillarNum;
    }

    public List<Bridge> getBridges() {
        return bridges;
    }

    private Integer nowPillarNum(Pillar previousPillar) {
        if (previousPillar == null)
            return Ladder.MINIMUM_PILLAR_NUM;
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

    private List<Bridge> createBridges(InputData inputData, Pillar previousPillar) {
        if (isFirstPillar(previousPillar))
            return createRightBridges(createRandomIntegers(inputData.getLadderHeight()));
        if (isLastPillar(inputData, previousPillar))
            return createLeftBridges(previousPillar);
        return createLeftRightBridges(previousPillar, inputData.getLadderHeight());
    }


    private boolean isLastPillar(InputData inputData, Pillar previousPillar) {
        if (inputData.getLadderWidth() - previousPillar.getPillarNum() == 1)
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
                .map(b -> createOneRightBridge(b))
                .collect(Collectors.toList());
    }


    private List<Bridge> createLeftBridges(Pillar previous) {
        List<Integer> locationsOfBridge = previous.getBridgesDirectionLocation(LinkedType.RIGHT);
        return locationsOfBridge.stream()
                .map(b -> createOneLeftBridge(b))
                .collect(Collectors.toList());
    }

    private Bridge createOneRightBridge(Integer location) {
        return (new Bridge(location, LinkedType.RIGHT));
    }

    private Bridge createOneLeftBridge(Integer location) {
        return (new Bridge(location, LinkedType.LEFT));
    }
}