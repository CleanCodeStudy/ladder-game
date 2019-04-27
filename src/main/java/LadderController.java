import domain.Ladder;
import domain.PillarFactory;
import dto.UserInputDto;
import view.InputView;

public class LadderController {

    private static InputView inptView;

    public static void main(String[] args) {
        UserInputDto inputDto = inptView.getInputDto();

        PillarFactory factory = new PillarFactory(inputDto);

        Ladder ladder = new Ladder(factory);
    }


}
