package view;

import domain.Bridge;
import domain.ExecuteResult;
import domain.User;
import dto.GameInformationDto;
import dto.GameResultDto;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    private static final String PILLAR = "|";
    private static final String BRIDGE = "-----";
    private static final String BLANK = "     ";

    private OutputView(){};

    public static void printLadder(GameResultDto gameResultDto,GameInformationDto gameInformationDto){
        printUserNames(gameInformationDto.getPlayers());
        List<Bridge> bridges = gameResultDto.getBridges();
        for(int i = 0 ; i < bridges.size() ; i++){
            System.out.print(PILLAR);

            String bridge = bridges.get(i).getPoints().stream()
                    .limit(gameInformationDto.getPlayers().size()-1)
                    .map(point -> point.isRightLinked() ? BRIDGE : BLANK)
                    .collect(Collectors.joining(PILLAR));

            System.out.print(bridge);
            System.out.print(PILLAR);
            System.out.println();
        }

        printExecuteResult(gameInformationDto.getExecuteResult());

    }

    public static void printUserNames(List<User> users){
        for (User user : users){
            System.out.print(user.getName());
            System.out.print("     ");
        }
        System.out.println();
    }

    public static void printExecuteResult(List<ExecuteResult> results){
        for (ExecuteResult result : results){
            System.out.print(result.getResult());
            System.out.print("     ");
        }
        System.out.println();
    }

    public static void printUserResult(String name,GameResultDto gameResultDto){
        System.out.println("실행결과");
        if(!name.equals("all")){
            System.out.println(gameResultDto.findByName(name).getResult());
            return;
        }

        Map<User, ExecuteResult> userPlayResult = gameResultDto.getUserPlayResult();

        userPlayResult.keySet().stream()
                .map(key -> String.format("%s : %s",key.getName(),gameResultDto.findByName(key.getName()).getResult()))
                .forEach(System.out::println);
    }
}
