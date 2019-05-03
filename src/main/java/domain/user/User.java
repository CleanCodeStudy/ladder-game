package domain.user;

import domain.ladder.Pillar;

public class User {

    private String name;
    private Pillar startPillar;

    public User(String name, Pillar pillar) {
        this.name = name;
        this.startPillar = pillar;
    }

    public String getName() {
        return name;
    }

    public Pillar getStartPillar() {
        return startPillar;
    }
}
