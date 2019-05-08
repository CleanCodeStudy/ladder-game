package dto;

import java.util.Arrays;
import java.util.List;

public class GameInformationDto {
    public static final String SPLITTER = ",";
    private List<String> players;
    private List<String> executeResult;
    private int ladderHeight;

    public GameInformationDto(String players, String executeResult, int ladderHeight) {
        this.players = stringSplitter(players);
        this.executeResult = stringSplitter(executeResult);
        this.ladderHeight = ladderHeight;
    }

    public List<String> getPlayers() {
        return players;
    }

    public List<String> getExecuteResult() {
        return executeResult;
    }

    public int getLadderHeight() {
        return ladderHeight;
    }

    public List<String> stringSplitter(String splitTarget) {
        return Arrays.asList(splitTarget.split(SPLITTER));
    }
}
