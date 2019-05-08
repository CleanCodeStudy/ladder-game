package domain;

import domain.ExecuteResult;
import domain.generator.LadderGenerator;
import domain.User;
import dto.GameResultDto;
import domain.Ladder;
import dto.GameInformationDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {
    private GameInformationDto gameInformationDto;
    private Ladder ladder;

    public LadderGame(GameInformationDto gameInformationDto) {
        this.gameInformationDto = gameInformationDto;
        ladder = LadderGenerator.generate(gameInformationDto.getLadderHeight(),gameInformationDto.getPlayers().size());
    }

    public GameResultDto getGameResult(){
        List<User> userList = gameInformationDto.getPlayers();
        List<ExecuteResult> executeResults = gameInformationDto.getExecuteResult();

        Map<User, ExecuteResult> userPlayResult = getUserPlayResult(userList,executeResults);

        return new GameResultDto(ladder,userPlayResult);
    }

    public Map<User, ExecuteResult> getUserPlayResult(List<User> userList, List<ExecuteResult> playResults){
        Map<User , ExecuteResult> userPlayResult = new HashMap<>();

        for(int i = 0; i < userList.size() ; i++){
            int startColumn = userList.get(i).getStartColumn();
            int resultColumn = ladder.progressAllStep(startColumn);

            userPlayResult.put(userList.get(i),playResults.get(resultColumn-1));
        }

        return userPlayResult;
    }
}
