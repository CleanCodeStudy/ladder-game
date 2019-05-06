import domain.ladder.Ladder;
import domain.ladder.ladderFactory.RandomLadderFactory;
import domain.ladder.ladderResult.LadderResult;
import dto.UserInputDto;
import view.InputView;
import view.OutputView;

public class LadderController {

    private static InputView inputView = new InputView(System.in);
    private static OutputView outputView;

    public static void main(String[] args) {
        UserInputDto inputDto = inputView.getInputDto();

        RandomLadderFactory factory = new RandomLadderFactory(inputDto);

        Ladder ladder = factory.createLadder();
        LadderResult ladderResult = ladder.start();

        outputView = new OutputView(ladder, ladderResult);

        outputView.showLadder();
        outputView.showResult(inputView.getPrize());
    }


}
