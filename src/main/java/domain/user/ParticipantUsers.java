package domain.user;

import dto.GameStartOption;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static util.RandomIntegerMaker.separateUserName;

public class ParticipantUsers {
    private List<User> users;

    private ParticipantUsers(GameStartOption gameStartOption) {
        this.users = createUser(gameStartOption.getParticipants());
    }

    public static ParticipantUsers of(GameStartOption gameStartOption){
        return new ParticipantUsers(gameStartOption);
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
