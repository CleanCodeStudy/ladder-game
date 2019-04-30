package domain;

import data.InputDatas;
import util.Util;

import java.util.ArrayList;
import java.util.List;

public class Pillar {
    private List<Bridge> bridges;
    private Integer pillarNum;

    public Pillar(InputDatas inputDatas, Pillar previousPillar) { //자동으로 다리생성
        pillarNum = myPillarNum(previousPillar);
        bridges = createRightBridge(Util.createRandomBooleans(inputDatas.getLadderHeight()));
    }

    public Pillar(List<Boolean> presenceBridges, Pillar previousPillar) { //수동으로 다리생성
        pillarNum = myPillarNum(previousPillar);
        bridges = createRightBridge(presenceBridges);
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

//    private List<domain.Bridge> LinkBrigedWithPreviousPillars (domain.Pillar previousPillar){
//        previousPillar.getBridges();
//    }

//    public List<domain.Bridge> getRightLinkingBrideges(){
//
//    }
//
//    public List<domain.Bridge> getLeftLinkingBrdiges(){
//
//    }

//    private List<domain.Bridge> createRightBridge(){
//
//    }

    private List<Bridge> createRightBridge(List<Boolean> locationsOfBridge) {
        int ladderHeight = locationsOfBridge.size();
        List<Bridge> bridges = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            if (locationsOfBridge.get(i) == true)
                bridges.add(createOneRightBridge(i));
        }
        return bridges;
//        return locationsOfBridge.stream()
//                .map(location -> locationsOfBridge.indexOf(location))
//                .map(intLocation -> createOneRightBridge(intLocation))
//                .collect(Collectors.toList());
    }


    private Bridge createOneRightBridge(Integer location) {
        return (new Bridge(location, LinkedType.RIGHT));
    }

    private Bridge createOneLeftBridge(Integer location) {
        return (new Bridge(location, LinkedType.LEFT));
    }
}