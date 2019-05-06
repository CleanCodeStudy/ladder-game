package domain.ladder;

import domain.direction.Direction;

import java.util.List;

public class Pillar {

    private TopAndBottom topAndBottom;
    private List<Point> points;

    public Pillar(TopAndBottom topAndBottom, List<Point> points) {
        this.topAndBottom = topAndBottom;
        this.points = points;
    }

    public String getUserName() {
        return topAndBottom.getUser();
    }

    public String getReward() {
        return topAndBottom.getReward();
    }

    public Direction getPointDirection(int x, int y) {
        return getPointByXY(x, y)
                .getDirection();
    }

    private Point getPointByXY(int x, int y) {
        return points.stream()
                .filter(point -> point.isPresentXY(x, y))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    public boolean hasXY(int x, int y) {
        return points.stream()
                .filter(point -> point.isPresentXY(x, y))
                .count() > 0;
    }

    public static Pillar createFirst(TopAndBottom topAndBottom, int height) {
        return new Pillar(topAndBottom, PointGenerator.createFirst(height));
    }

    public static Pillar createMiddle(TopAndBottom topAndBottom, Pillar before) {
        return new Pillar(topAndBottom, PointGenerator.createMiddle(before.points));
    }

    public static Pillar createLast(TopAndBottom topAndBottom, Pillar before) {
        return new Pillar(topAndBottom, PointGenerator.createLast(before.points));
    }
}
