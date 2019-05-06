package domain.ladder.ladderResult;

import domain.ladder.Ladder;
import domain.ladder.Reward;
import domain.ladder.User;

import java.util.ArrayList;
import java.util.List;

public class LadderResult {
    private final int START = 0;
    private final int DOWN = 1;

    private List<Pair> pairs;
    private Ladder ladder;

    public LadderResult(Ladder ladder) {
        this.ladder = ladder;
        pairs = createPairs();
    }

    public List<Pair> getAllRewards() {
        return new ArrayList<>(pairs);
    }

    private List<Pair> createPairs() {
        List<Pair> pairs = new ArrayList<>();
        for (int x = START; x < ladder.getNames().size(); x++) {
            addPair(pairs, x);
        }
        return pairs;
    }

    private void addPair(List<Pair> pairs, int x) {
        int y = START;
        User user = new User(ladder.findNameByX(x));
        x = findEndX(x, y);
        Reward reward = new Reward(ladder.findRewardByX(x));
        pairs.add(new Pair(user, reward));
    }

    private int findEndX(int x, int y) {
        while (!isBottom(y)) {
            x = moveX(x, y);
            y = moveY(y);
        }
        return x;
    }

    private boolean isBottom(int y) {
        return y == ladder.getHeight();
    }

    private int moveX(int x, int y) {
        return x + ladder.getDirection(x, y).getOffset();
    }

    private int moveY(int y) {
        return y + DOWN;
    }

    public String findRewardByName(String name) {
        return pairs.stream()
                .filter(pair -> pair.isEqualName(name))
                .findFirst()
                .orElseThrow(RuntimeException::new)
                .getReward();
    }

}
