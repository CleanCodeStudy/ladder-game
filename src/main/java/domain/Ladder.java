package domain;

import dto.GameInformationDto;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private int ladderHeight;
    private int playerNumber;
    private List<Bridge> bridges;

    public Ladder(int ladderHeight,int playerNumber ,List<Bridge> bridges) {
        this.ladderHeight = ladderHeight;
        this.playerNumber = playerNumber;
        this.bridges = bridges;
    }

    public int getLadderHeight() {
        return ladderHeight;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public List<Bridge> getBridges() {
        return bridges;
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
