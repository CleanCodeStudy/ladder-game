package domain.direction;

import domain.ladder.Point;
import domain.ladder.PointGenerator;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class PointGeneratorTest {

    Direction down;
    Direction right;
    Direction left;
    int height;

    @Before
    public void setUp() {
        down = Direction.DOWN;
        right = Direction.RIGHT;
        left = Direction.LEFT;
        height = 50;
    }


    @Test
    public void 첫번째_방향들_만들기() {

        PointGenerator generator = new PointGenerator();
        List<Point> points = generator.createFirst(height);

        assertThat(points.size()).isEqualTo(height);

        List<Direction> directions = points.stream()
                .map(p -> p.getDirection())
                .collect(Collectors.toList());

        System.out.println(directions.toString());

        assertThat(directions).containsAnyElementsOf(Arrays.asList(down, right));
    }

    @Test
    public void 중간기둥들의_방향_만들기() {

        PointGenerator generator = new PointGenerator();
        List<Point> before = generator.createFirst(height);

        List<Point> points = generator.createMiddle(before);

        assertThat(points.size()).isEqualTo(height);

        List<Direction> directions = points.stream()
                .map(point -> point.getDirection())
                .collect(Collectors.toList());

        System.out.println(directions.toString());

        assertThat(directions).containsAnyElementsOf(Arrays.asList(down, right, left));
    }

    @Test
    public void 마지막기둥의_방향_만들기() {

        PointGenerator generator = new PointGenerator();
        List<Point> before = generator.createFirst(height);

        List<Point> points = generator.createLast(before);
        List<Direction> directions = points.stream()
                .map(point -> point.getDirection())
                .collect(Collectors.toList());

        System.out.println(directions.toString());

        assertThat(directions).containsAnyElementsOf(Arrays.asList(down, left));
    }
}