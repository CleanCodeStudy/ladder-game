import domain.Ladder;
import domain.PillarFactory;
import dto.UserInputDto;
import view.InputView;
import view.OutputView;

public class LadderController {

    private static InputView inptView = new InputView(System.in);

    public static void main(String[] args) {
        UserInputDto inputDto = inptView.getInputDto();

        PillarFactory factory = new PillarFactory(inputDto);

        Ladder ladder = new Ladder(factory);

        OutputView outputView = new OutputView(ladder);

        outputView.showLadder();
    }


}
