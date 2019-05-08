package dto;

import domain.Bridge;
import domain.ExecuteResult;
import domain.Ladder;
import domain.User;

import java.util.List;
import java.util.Map;

public class GameResultDto {
    private final static ExecuteResult NO_USER = new ExecuteResult("해당 사용자는 없습니다.",0);
    private Ladder ladder;
    private Map<User, ExecuteResult> userPlayResult;

    public GameResultDto(Ladder ladder, Map<User, ExecuteResult> userPlayResult) {
        this.ladder = ladder;
        this.userPlayResult = userPlayResult;
    }

    public Map<User, ExecuteResult> getUserPlayResult() {
        return userPlayResult;
    }

    public List<Bridge> getBridges(){
        return ladder.getBridges();
    }

    public ExecuteResult findByName(String name){
        User find = userPlayResult.keySet().stream()
                .filter(user -> user.getName().equals(name))
                .findFirst()
                .get();

        return userPlayResult.getOrDefault(find,NO_USER);
    }

    public ExecuteResult findByColumnNum(int column) {

        User find = userPlayResult.keySet().stream()
                .filter(user -> user.getStartColumn() == column)
                .findFirst()
                .get();

        return userPlayResult.getOrDefault(find,NO_USER);
    }

}
