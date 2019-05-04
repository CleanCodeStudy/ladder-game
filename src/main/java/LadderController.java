import dto.GameInformationDto;
import dto.GameResultDto;
import view.InputView;
import view.OutputView;

public class LadderController {

    public static void main(String[] args) {
        InputView inputView = new InputView(System.in);

        GameInformationDto gameInformationDto = inputView.getGameInformationDto();

        LadderGame ladderGame = new LadderGame(gameInformationDto);

        GameResultDto gameResultDto = ladderGame.getGameResult();

        OutputView outputView = new OutputView(gameResultDto);

        outputView.printLadder();

        String name;

        do{
            name = inputView.inputTargetPlayer();
            outputView.printExecuteResult(name);
        }while(!name.equals("all"));
    }
}
