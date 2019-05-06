package dto;

import domain.ladder.Reward;
import domain.ladder.TopAndBottom;
import domain.ladder.User;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UserInputDto {
    private static final String DELIMITER = ",";

    private List<String> names;
    private int height;
    private List<String> rewards;

    public UserInputDto(String names, int height, String rewards) {
        this.rewards = Arrays.asList(rewards.split(DELIMITER));
        this.height = height;
        this.names = Arrays.asList(names.split(DELIMITER));
        validateInput();
    }

    public List<String> getNames() {
        return this.names;
    }

    public int getHeight() {
        return height;
    }

    private void validateInput() {
        int people = names.size();
        validateUser(people);
        validateHeight();
        validateRewards(people);
    }

    private void validateRewards(int people) {
        if (this.rewards.size() != people) {
            throw new IllegalArgumentException("인원수 만큼 결과를 입력하세요.");
        }
    }

    private void validateUser(int people) {
        if (people < 2) {
            throw new IllegalArgumentException("2명 이상 입력하세요.");
        }
    }

    private void validateHeight() {
        if (height < 1) {
            throw new IllegalArgumentException("높이를 1이상 입력하세요.");
        }
    }


    public List<TopAndBottom> toEntities() {
        List<User> users = createUsers();
        List<Reward> rewards = createRewards();
        return IntStream.range(0, users.size())
                .mapToObj(i -> new TopAndBottom(users.get(i), rewards.get(i)))
                .collect(Collectors.toList());
    }

    private List<User> createUsers() {
        return this.names.stream()
                .map(name -> new User(name))
                .collect(Collectors.toList());
    }

    private List<Reward> createRewards() {
        return this.rewards.stream()
                .map(reward -> new Reward(reward))
                .collect(Collectors.toList());
    }

}
