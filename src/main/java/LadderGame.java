import domain.User;
import dto.GameResultDto;
import domain.Ladder;
import dto.GameInformationDto;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {
    private GameInformationDto gameInformationDto;
    private Ladder ladder;

    public LadderGame(GameInformationDto gameInformationDto) {
        this.gameInformationDto = gameInformationDto;
        ladder = Ladder.createLadder(gameInformationDto);
    }

    public GameResultDto getGameResult(){
        List<String> userNames = gameInformationDto.getPlayers();
        List<String> executeResults = gameInformationDto.getExecuteResult();
        List<User> userList = IntStream.range(0,userNames.size())
                .mapToObj(i->new User(userNames.get(i),i+1))
                .collect(Collectors.toList());

        HashMap<User,String> userPlayResult = getUserPlayResult(userList,executeResults);

        return new GameResultDto(ladder,userPlayResult,gameInformationDto);
    }

    public HashMap<User,String> getUserPlayResult(List<User> userList, List<String> playResults){
        HashMap<User ,String> userPlayResult = new HashMap<>();

        for(int i = 0; i < userList.size() ; i++){
            int startColumn = userList.get(i).getStartColumn();
            int resultColumn = ladder.progressAllStep(startColumn);

            userPlayResult.put(userList.get(i),playResults.get(resultColumn-1));
        }

        return userPlayResult;
    }
}
