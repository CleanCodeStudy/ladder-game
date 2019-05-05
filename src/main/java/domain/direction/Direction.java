package domain.direction;

import domain.ladder.Point;

import java.util.Random;

public enum Direction {

    RIGHT,
    DOWN,
    LEFT;

    public boolean isRight() {
        return this == RIGHT;
    }

    public boolean isLeft() {
        return this == LEFT;
    }

    public static Direction getRightOrDown() {
        return new Random().nextBoolean() ? RIGHT : DOWN;
    }

    public static Direction createMidDirection(Point point) {
        if (point.isRight()) {
            return LEFT;
        }
        if (point.isLeft()) {
            return DOWN;
        }
        return Direction.getRightOrDown();
    }

    public static Direction createLastDirection(Point point) {
        return point.isRight() ? LEFT : DOWN;
    }
}
