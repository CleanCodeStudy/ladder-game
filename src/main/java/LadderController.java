import domain.Ladder;
import domain.LadderFactory.RandomLadderFactory;
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

        outputView = new OutputView(ladder);

        outputView.showLadder();
    }


}
