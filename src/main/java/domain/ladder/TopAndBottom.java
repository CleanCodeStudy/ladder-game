package domain.ladder;

public class TopAndBottom {
    private User user;
    private Reward reward;

    public TopAndBottom(User user, Reward reward) {
        this.user = user;
        this.reward = reward;
    }

    public String getUser() {
        return user.getName();
    }

    public String getReward() {
        return reward.getValue();
    }
}
