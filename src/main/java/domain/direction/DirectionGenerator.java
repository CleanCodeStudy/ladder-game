package domain.direction;

import domain.ladder.Location;
import domain.ladder.Point;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DirectionGenerator {

    private static final int ANY = 0;
    private static final int DOWN = Direction.DOWN.getCode();
    private static final int RIGHT = Direction.RIGHT.getCode();
    private static final Map<Integer, Direction> RIGHT_AND_DOWN;

    static {
        RIGHT_AND_DOWN = getInstance();
    }

    private static Map<Integer, Direction> getInstance() {
        return IntStream.rangeClosed(RIGHT, DOWN)
                .mapToObj(code -> Direction.findByCode(code))
                .collect(Collectors.toMap(Direction::getCode, Function.identity()));
    }

    public static List<Point> createFirst(int height) {
        return IntStream.range(0, height)
                .mapToObj(y -> new Location(0, y))
                .map(location -> new Point(location, createEach()))
                .collect(Collectors.toList());
    }

    private static Direction createEach() {
        List<Integer> codes = new ArrayList<>(RIGHT_AND_DOWN.keySet());

        Collections.shuffle(codes);

        return Direction.findByCode(codes.get(ANY));
    }

    public static List<Point> createMiddle(List<Point> before) {
        return before.stream()
                .map(point -> Point.createNextPoint(point, createMidDirection(point)))
                .collect(Collectors.toList());
    }

    public static Direction createMidDirection(Point point) {
        if (point.isRight()) {
            return Direction.LEFT;
        }
        return createEach();
    }

    public static List<Point> createLast(List<Point> points) {
        return points.stream()
                .map(point -> Point.createNextPoint(point, createLastDirection(point)))
                .collect(Collectors.toList());
    }

    public static Direction createLastDirection(Point point) {
        if (point.isRight()) {
            return Direction.LEFT;
        }
        return Direction.DOWN;
    }

}
