package domain.ladder;

import domain.direction.Direction;

import java.util.List;

public class Pillar {

    private User user;
    private List<Point> points;

    public Pillar(User user, List<Point> points) {
        this.user = user;
        this.points = points;
    }

    public String getUserName() {
        return user.getName();
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

    public static Pillar createFirst(String name, int height) {
        return new Pillar(new User(name), PointGenerator.createFirst(height));
    }

    public static Pillar createMiddle(String name, Pillar before) {
        return new Pillar(new User(name), PointGenerator.createMiddle(before.points));
    }

    public static Pillar createLast(String name, Pillar before) {
        return new Pillar(new User(name), PointGenerator.createLast(before.points));
    }
}
