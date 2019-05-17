import domain.ladder.Ladder;
import domain.user.ParticipantUsers;
import dto.GameStartOption;
import view.InputView;
import view.OutputView;

public class LadderGame {

    public static void main(String args[]) {
        GameStartOption gameStartOption = InputView.of(System.in).initGameStartOption();
        Ladder ladder = Ladder.of(gameStartOption);
        ParticipantUsers userManage = ParticipantUsers.of(gameStartOption);
        OutputView print = OutputView.of(userManage, ladder);

        print.drawUserNames();
        print.drawOutput();

    }
}
