package domain.ladder;

import domain.direction.Direction;

public class Point {
    private Location location;
    private Direction direction;

    public static Point createNextPoint(Point before, Direction direction) {
        Location nextLocation = new Location(before.location);
        return new Point(nextLocation, direction);
    }

    public Point(Location location, Direction direction) {
        this.location = location;
        this.direction = direction;
    }

    public int getX() {
        return this.location.getX();
    }

    public int getY() {
        return this.location.getY();
    }

    public Direction getDirection() {
        return this.direction;
    }

    public boolean isRight() {
        return this.direction == Direction.RIGHT;
    }

    public boolean isLocationXY(int x, int y) {
        return this.location.isEqual(x, y);
    }
}
