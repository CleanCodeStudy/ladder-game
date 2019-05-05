package view;

import domain.Bridge;
import domain.User;
import dto.GameResultDto;
import domain.LinkedType;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String PILLAR = "|";
    private static final String BRIDGE = "-----";
    private static final String BLANK = "     ";
    private static final String NEXT_LINE = "\n";

    private GameResultDto gameResultDto;

    public OutputView(GameResultDto gameResultDto) {
        this.gameResultDto = gameResultDto;
    }

    public void printLadder(){

        List<String> userNames = gameResultDto.getUserNames();
        List<Bridge> bridges = gameResultDto.getBridges();
        List<String> executeResults = gameResultDto.getExecuteResults();

        StringBuilder ladderShow = new StringBuilder();

        ladderShow.append(userNames.stream()
                .collect(Collectors.joining(" ")) + NEXT_LINE);


        for(int i = 0 ; i < bridges.size() ; i++){
            String bridgeShow = PILLAR;

            bridgeShow += bridges.get(i).getPoints().stream()
                    .limit(userNames.size()-1)
                    .map(point -> getBridgeType(point.getLinkedType()))
                    .collect(Collectors.joining(PILLAR));

            bridgeShow += PILLAR;

            ladderShow.append(bridgeShow + NEXT_LINE);
        }

        ladderShow.append(executeResults);

        System.out.println(ladderShow.toString());

    }

    public String getBridgeType(LinkedType linkedType){
        if(linkedType == LinkedType.RIGHT){
            return BRIDGE;
        }
        return BLANK;
    }

    public void printExecuteResult(String name){
        System.out.println("실행결과");
        if(!name.equals("all")){
            System.out.println(gameResultDto.findByName(name));
            return;
        }

        HashMap<User,String> userPlayResult = gameResultDto.getUserPlayResult();

        userPlayResult.keySet().stream()
                .map(key -> String.format("%s : %s",key.getName(),gameResultDto.findByName(key.getName())))
                .forEach(System.out::println);
    }
}
