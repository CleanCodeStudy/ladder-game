import java.util.List;

public class LadderGame {
    private UAP uap;
    private Ladder ladder;

    public LadderGame(UAP uap,LadderMaker maker) {
        this.uap = uap;
        this.ladder = maker.generateLadder();
    }

    public Ladder getLadder() {
        return ladder;
    }
}
