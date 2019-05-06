package domain.ladder.ladderResult;

import domain.ladder.Reward;
import domain.ladder.User;

public class Pair {
    private User user;
    private Reward reward;

    public Pair(User user, Reward reward) {
        this.user = user;
        this.reward = reward;
    }

    public String getUserName() {
        return user.getName();
    }

    public String getReward() {
        return reward.getValue();
    }

    public boolean isEqualName(String name) {
        return this.user.getName().equals(name);
    }
}
