package domain;

import dto.GameInformationDto;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private Integer ladderHeight;
    private Integer playerNumber;
    private List<Bridge> bridges;

    public Ladder(Integer ladderHeight,Integer playerNumber ,List<Bridge> bridges) {
        this.ladderHeight = ladderHeight;
        this.playerNumber = playerNumber;
        this.bridges = bridges;
    }

    public Integer getLadderHeight() {
        return ladderHeight;
    }

    public Integer getPlayerNumber() {
        return playerNumber;
    }

    public List<Bridge> getBridges() {
        return bridges;
    }

    public static Ladder createLadder(GameInformationDto gameInformationDto){
        Integer ladderHeight = gameInformationDto.getLadderHeight();
        Integer playerNumber = gameInformationDto.getPlayers().size();
        List<Bridge> bridges = new ArrayList<>();

        for(int i = 0 ; i < ladderHeight ; i++){
            Bridge bridge = Bridge.createBridge(i+1,playerNumber);
            bridges.add(bridge);
        }

        return new Ladder(ladderHeight,playerNumber,bridges);
    }

    public Integer progressAllStep(int startColumn) {
        validatePosition(startColumn);

        int currentColumn = startColumn;

        for(int currentHeight = 0 ; currentHeight < ladderHeight ; currentHeight++){
            Bridge currentBridge = bridges.get(currentHeight);
            currentColumn = currentBridge.nextPoint(currentColumn).getColumn();
        }

        return currentColumn;
    }

    public void validatePosition(int column){
        if(column > playerNumber){
            throw new IllegalArgumentException("Out of Player Number Range");
        }
    }
}
