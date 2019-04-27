package domain;

import domain.direction.Direction;

import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    private List<Pillar> pillars;
    private int height;

    public Ladder(PillarFactory factory) {
        this.pillars = factory.createPillars();
        this.height = pillars.get(0).getHeight();
    }

    public Direction getPillarDirection(int x, int y) {
        return this.pillars.get(x)
                .getDirections()
                .get(y);
    }

    public int getHeight() {
        return height;
    }

    public List<String> getNames() {
        return pillars.stream()
                .map(Pillar::getUserName)
                .collect(Collectors.toList());
    }
}
