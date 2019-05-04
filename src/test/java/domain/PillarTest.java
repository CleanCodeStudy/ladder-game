package domain;

import domain.direction.Direction;
import domain.ladder.Location;
import domain.ladder.Pillar;
import domain.ladder.Point;
import domain.ladder.User;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class PillarTest {
    User user;
    String name;
    int height;
    List<Point> points = new ArrayList<>();
    Pillar leftPillar;

    @Before
    public void setUp() throws Exception {
        name = "park";
        height = 10;
        user = new User(name);
        List<Location> locations = getLocations();
        points.addAll(getRightPoints(locations));
        points.addAll(getDownPoints(locations));
        points.addAll(getLeftPoints(locations));
        leftPillar = new Pillar(user, points);
    }

    private List<Location> getLocations() {
        return IntStream.rangeClosed(0, 9)
                .mapToObj(y -> new Location(0, y))
                .collect(Collectors.toList());
    }

    private List<Point> getRightPoints(List<Location> locations) {
        return IntStream.rangeClosed(0, 3)
                .mapToObj(idx -> new Point(locations.get(idx), Direction.RIGHT))
                .collect(Collectors.toList());
    }

    private List<Point> getDownPoints(List<Location> locations) {
        return IntStream.rangeClosed(4, 6)
                .mapToObj(idx -> new Point(locations.get(idx), Direction.DOWN))
                .collect(Collectors.toList());
    }

    private List<Point> getLeftPoints(List<Location> locations) {
        return IntStream.rangeClosed(7, 9)
                .mapToObj(idx -> new Point(locations.get(idx), Direction.LEFT))
                .collect(Collectors.toList());
    }

    @Test
    public void 첫번째_기둥_만들기() {
        Pillar first = Pillar.createFirst(name, height);

        assertThat(first.getUserName()).isEqualTo(name);

        IntStream.rangeClosed(0, 9)
                .forEach(y -> assertThat(first.hasXY(0, y)).isTrue());

    }

    @Test
    public void 중간_기둥_만들기() {
        String userName = "kim";
        Pillar pillar = Pillar.createMiddle(userName, leftPillar);

        assertThat(pillar.getUserName()).isEqualTo(userName);

        List<Direction> directions = IntStream.rangeClosed(0, 3)
                .mapToObj(idx -> pillar.getPointDirection(1,idx))
                .collect(Collectors.toList());

        assertThat(directions).containsOnly(Direction.LEFT);

        directions = IntStream.rangeClosed(4, 6)
                .mapToObj(idx -> pillar.getPointDirection(1,idx))
                .collect(Collectors.toList());

        assertThat(directions).containsAnyOf(Direction.DOWN, Direction.RIGHT);

        directions = IntStream.rangeClosed(7, 9)
                .mapToObj(idx -> pillar.getPointDirection(1,idx))
                .collect(Collectors.toList());

        assertThat(directions).containsAnyOf(Direction.DOWN, Direction.RIGHT);
    }

    @Test
    public void 마지막_기둥_만들기() {
        String userName = "kim";
        Pillar pillar = Pillar.createLast(userName, leftPillar);

        assertThat(pillar.getUserName()).isEqualTo(userName);

        List<Direction> directions = IntStream.rangeClosed(0, 3)
                .mapToObj(idx -> pillar.getPointDirection(1,idx))
                .collect(Collectors.toList());

        assertThat(directions).containsOnly(Direction.LEFT);

        directions = IntStream.rangeClosed(4, 6)
                .mapToObj(idx -> pillar.getPointDirection(1,idx))
                .collect(Collectors.toList());

        assertThat(directions).containsOnly(Direction.DOWN);

        directions = IntStream.rangeClosed(7, 9)
                .mapToObj(idx -> pillar.getPointDirection(1,idx))
                .collect(Collectors.toList());

        assertThat(directions).containsOnly(Direction.DOWN);
    }

}