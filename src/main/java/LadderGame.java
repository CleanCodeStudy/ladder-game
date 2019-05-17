import domain.ladder.Ladder;
import domain.ladderCalculator.LadderIO;
import dto.GameStartOption;
import view.InputView;
import view.OutputLadder;

public class LadderGame {

    public static void main(String args[]) {
        InputView inputView = InputView.of(System.in);
        GameStartOption gameStartOption = inputView.initGameStartOption();
        Ladder ladder = Ladder.of(gameStartOption);
        LadderIO ladderIO = LadderIO.of(gameStartOption);
        OutputLadder ladderPrint = OutputLadder.of(ladderIO, ladder);

        ladderPrint.drawUserNames();
        ladderPrint.drawOutput();
        ladderPrint.drawResults();

        while (true) {
            String ask = inputView.showResultUser();
            ladderPrint.showLadderResult(ask);
        }

    }

}
