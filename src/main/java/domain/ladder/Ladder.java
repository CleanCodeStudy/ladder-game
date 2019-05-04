package domain.ladder;

import domain.direction.Direction;

import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    private List<Pillar> pillars;
    private int height;

    public Ladder(List<Pillar> pillars, int height) {
        this.pillars = pillars;
        this.height = height;
    }

    public Direction getDirection(int x, int y) {
        return pillars.stream()
                .filter(pillar -> pillar.hasXY(x, y))
                .map(pillar -> pillar.getPointDirection(x, y))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    public int getHeight() {
        return this.height;
    }

    public List<String> getNames() {
        return pillars.stream()
                .map(Pillar::getUserName)
                .collect(Collectors.toList());
    }
}
