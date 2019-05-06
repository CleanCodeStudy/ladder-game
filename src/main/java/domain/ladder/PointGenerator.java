package domain.ladder;

import domain.direction.Direction;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PointGenerator {

    public static List<Point> createFirst(int height) {
        return IntStream.range(0, height)
                .mapToObj(y -> new Location(0, y))
                .map(location -> new Point(location, Direction.getRightOrDown()))
                .collect(Collectors.toList());
    }

    public static List<Point> createMiddle(List<Point> before) {
        return before.stream()
                .map(point -> Point.createNextPoint(point, Direction.createMidDirection(point)))
                .collect(Collectors.toList());
    }

    public static List<Point> createLast(List<Point> points) {
        return points.stream()
                .map(point -> Point.createNextPoint(point, Direction.createLastDirection(point)))
                .collect(Collectors.toList());
    }

}
