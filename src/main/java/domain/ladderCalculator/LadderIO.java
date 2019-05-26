package domain.ladderCalculator;

import domain.ladder.Ladder;
import domain.ladder.Pillar;
import dto.GameStartOption;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static util.RandomIntegerMaker.separateByDelimiter;

public class LadderIO {

    private List<String> users;
    private List<String> results;

    private LadderIO(GameStartOption gameStartOption) {
        this.users = separateByDelimiter(gameStartOption.getParticipants());
        this.results = separateByDelimiter(gameStartOption.getResults());
    }

    public static LadderIO of(GameStartOption gameStartOption) {
        return new LadderIO(gameStartOption);
    }

    public List<String> getUsers() {
        return users;
    }

    public List<String> getResults() {
        return results;
    }

    public String findResult(Ladder ladder, String userName) {
        int row = 0;
        Pillar pillar = ladder.getPillarByNum(users.indexOf(userName));
        while (row < ladder.getHeight()) {
            pillar = ladder.getNextPillar(pillar, row);
            row++;
        }
        return results.get(pillar.getPillarNum());
    }

    public int getUserCharMaxNum() {
        List<Integer> lengths = users.stream()
                .map(u -> u.length())
                .collect(Collectors.toList());
        return Collections.max(lengths);
    }

}
