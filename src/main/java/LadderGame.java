import data.InputData;
import domain.ladder.Ladder;
import domain.user.UserManage;
import view.InputView;

public class LadderGame {

    public static void main(String args[]) {
        InputView inputView = new InputView(System.in);
        InputData inputData = new InputData(inputView.participants(), inputView.ladderHeight());
        Ladder ladder = new Ladder(inputData);
        UserManage userManage = new UserManage(inputData, ladder);
        
    }

}
