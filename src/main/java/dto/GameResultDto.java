package dto;

import domain.Bridge;
import domain.Ladder;
import domain.User;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class GameResultDto {
    private final static String NO_USER = "해당 User는 존재하지않습니다.";
    private Ladder ladder;
    private HashMap<User,String> userPlayResult;
    private GameInformationDto gameInformationDto;

    public GameResultDto(Ladder ladder, HashMap<User, String> userPlayResult,GameInformationDto gameInformationDto) {
        this.ladder = ladder;
        this.userPlayResult = userPlayResult;
        this.gameInformationDto = gameInformationDto;
    }

    public HashMap<User, String> getUserPlayResult() {
        return userPlayResult;
    }

    public List<Bridge> getBridges(){
        return ladder.getBridges();
    }

    public List<String> getUserNames(){
        return gameInformationDto.getPlayers();
    }

    public List<String> getExecuteResults(){
        return gameInformationDto.getExecuteResult();
    }

    public String findByName(String name){
        User find = userPlayResult.keySet().stream()
                .filter(user -> user.getName().equals(name))
                .findFirst()
                .orElse(null);

        return userPlayResult.getOrDefault(find,NO_USER);
    }

    public String findByColumnNum(int column) {

        User find = userPlayResult.keySet().stream()
                .filter(user -> user.getStartColumn() == column)
                .findFirst()
                .orElse(null);

        return userPlayResult.getOrDefault(find,NO_USER);
    }

}
