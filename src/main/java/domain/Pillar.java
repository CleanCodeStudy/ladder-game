package domain;

import domain.direction.DirectionGenerator;

import java.util.List;

public class Pillar {

    private User user;
    private List<Point> points;

    public static Pillar createFirst(String name, int height) {
        return new Pillar(new User(name), DirectionGenerator.createFirst(height));
    }

    public static Pillar createMiddle(String name, Pillar before) {
        return new Pillar(new User(name), DirectionGenerator.createMiddle(before.points));
    }

    public static Pillar createLast(String name, Pillar before) {
        return new Pillar(new User(name), DirectionGenerator.createLast(before.points));
    }

    public Pillar(User user, List<Point> points) {
        this.user = user;
        this.points = points;
    }

    public String getUserName() {
        return user.getName();
    }

    public List<Point> getPoints() {
        return points;
    }

    public int getHeight() {
        return points.size();
    }

    public int getX() {
        return points.get(0).getX();
    }

    public boolean isEqualToX(int x) {
        return getX() == x;
    }
}
