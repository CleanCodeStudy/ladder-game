package dto;

import domain.ExecuteResult;
import domain.User;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameInformationDto {
    public static final String SPLITTER = ",";
    private List<String> players;
    private List<String> executeResult;
    private int ladderHeight;

    public GameInformationDto(String players, String executeResult, int ladderHeight) {
        this.players = stringSplitter(players);
        this.executeResult = stringSplitter(executeResult);
        this.ladderHeight = ladderHeight;
        validateSize(this.players,this.executeResult);
    }

    public List<User> getPlayers() {
        return IntStream.range(0,players.size())
                .mapToObj(i->new User(players.get(i),i+1))
                .collect(Collectors.toList());
    }

    public List<ExecuteResult> getExecuteResult() {
        return IntStream.range(0,executeResult.size())
                .mapToObj(i->new ExecuteResult(executeResult.get(i),i+1))
                .collect(Collectors.toList());
    }

    public int getLadderHeight() {
        return ladderHeight;
    }

    public List<String> stringSplitter(String splitTarget) {
        return Arrays.asList(splitTarget.split(SPLITTER));
    }

    public void validateSize(List<String> players, List<String> executeResults){
        if(players.size() != executeResults.size()) {
            throw new IllegalArgumentException();
        }
    }
}
