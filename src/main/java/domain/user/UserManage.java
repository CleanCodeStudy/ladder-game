package domain.user;

import data.InputData;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static util.Util.separateUserName;

public class UserManage {
    private List<User> users;

    public UserManage(InputData inputData) {
        this.users = createUser(inputData.getParticipants());
    }

    public List<User> getUsers() {
        return users;
    }

    private List<User> createUser(String users) {
        return separateUserName(users).stream()
                .map(u -> new User(u))
                .collect(Collectors.toList());
    }

    public int getUserCharMaxNum() {
        List<Integer> lengths = users.stream()
                .map(u -> u.getName().length())
                .collect(Collectors.toList());
        return Collections.max(lengths);
    }


}
