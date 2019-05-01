package domain;

import domain.LadderFactory.LadderFactory;
import domain.direction.Direction;

import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    private List<Pillar> pillars;

    public Ladder(LadderFactory factory) {
        this.pillars = factory.createPillars();
    }

    public Direction getDirection(int x, int y) {
        List<Point> points = findPoint(x, y);

        return points.stream()
                .filter(point -> point.isLocationXY(x, y))
                .findFirst()
                .orElseThrow(RuntimeException::new)
                .getDirection();
    }

    private List<Point> findPoint(int x, int y) {
        return pillars.stream()
                .filter(pillar -> pillar.isEqualToX(x))
                .findFirst()
                .orElseThrow(RuntimeException::new)
                .getPoints();
    }

    public int getHeight() {
        return pillars.get(0).getHeight();
    }

    public List<String> getNames() {
        return pillars.stream()
                .map(Pillar::getUserName)
                .collect(Collectors.toList());
    }
}
