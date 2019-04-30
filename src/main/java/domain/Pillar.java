package domain;

import data.InputData;
import util.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Pillar {
    private List<Bridge> bridges;
    private Integer pillarNum;

    public Pillar(InputData inputData, Pillar previousPillar) { //자동으로 다리생성
        pillarNum = myPillarNum(previousPillar);
        bridges = createRightBridge(Util.createRandomIntegers(inputData.getLadderHeight()));
    }

    public Integer getPillarNum() {
        return pillarNum;
    }

    public List<Bridge> getBridges() {
        return bridges;
    }

    private Integer myPillarNum(Pillar previousPillar) {
        if (previousPillar == null)
            return Ladder.MINIMUM_PILLAR_NUM;
        return previousPillar.getPillarNum() + 1;
    }

    public List<Integer> getBridgesLocations(){
        return bridges.stream()
                .map(b->b.getLocation())
                .collect(Collectors.toList());
    }

    public List<Integer> getBridgesDirectionLocation(LinkedType linkedType){
        return bridges.stream()
                .filter(b->b.getLinkPillarDirection() == linkedType)
                .map(bridge->bridge.getLocation())
                .collect(Collectors.toList());
    }

//    private List<Bridge> createBridges(){
//
//
//    }

    private List<Bridge> createRightBridge(List<Integer> locationsOfBridge) {
        return locationsOfBridge.stream()
                .map(b -> createOneRightBridge(b))
                .collect(Collectors.toList());
    }

    private Bridge createOneRightBridge(Integer location) {
        return (new Bridge(location, LinkedType.RIGHT));
    }

    private Bridge createOneLeftBridge(Integer location) {
        return (new Bridge(location, LinkedType.LEFT));
    }
}