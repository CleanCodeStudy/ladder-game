package domain.user;

import data.InputData;
import domain.ladder.Ladder;
import domain.ladder.Pillar;

import java.util.ArrayList;
import java.util.List;

import static util.Util.separateUserName;

public class UserManage {
    private List<User> users;

    public UserManage(InputData inputData, Ladder ladder) {
        if (inputData.getLadderWidth() == ladder.getWidth()) {
            this.users = createUser(separateUserName(inputData.getParticipants()), ladder.getPillars());
        }
    }

    public List<User> getUsers() {
        return users;
    }

    private List<User> createUser(List<String> userNames, List<Pillar> pillars) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < userNames.size(); i++) {
            users.add(new User(userNames.get(i), pillars.get(i)));
        }
        return users;
    }

}
