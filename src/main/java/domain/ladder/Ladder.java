package domain.ladder;

import domain.direction.Direction;

import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    private List<Pillar> pillars;

    public Ladder(List<Pillar> pillars) {
        this.pillars = pillars;
    }

    public Direction getDirection(int x, int y) {
        List<Point> points = findPointByX(x);

        return points.stream()
                .filter(point -> point.isLocationXY(x, y))
                .findFirst()
                .orElseThrow(RuntimeException::new)
                .getDirection();
    }

    private List<Point> findPointByX(int x) {
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
