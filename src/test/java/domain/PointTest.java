package domain;

import domain.direction.Direction;
import domain.ladder.Location;
import domain.ladder.Point;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    Location location;
    int beforeX;
    int beforeY;
    Direction right;
    Direction left;
    Point before;

    @Before
    public void setUp() throws Exception {
        beforeX = 1;
        beforeY = 3;
        location = new Location(beforeX, beforeY);
        right = Direction.RIGHT;
        left = Direction.LEFT;
        before = new Point(location, right);
    }

    @Test
    public void Y좌표값_가져오기() {
        int y = before.getY();
        assertThat(y).isEqualTo(beforeY);
    }

    @Test
    public void X좌표값_가져오기() {
        int x = before.getX();
        assertThat(x).isEqualTo(beforeX);
    }

    @Test
    public void 왼쪽점을_이용해서_새로운점_만들기() {
        Point now = Point.createNextPoint(before, left);

        int nowX = now.getX();
        int nowY = now.getY();

        assertThat(nowX).isEqualTo(beforeX + 1);
        assertThat(nowY).isEqualTo(beforeY);
    }

    @Test
    public void 현재_Point의_방향값가져오기() {
        Direction direction = before.getDirection();
        assertThat(direction).isEqualTo(right);
    }

    @Test
    public void 현재_Point의_방향값이_오른쪽인지_확인하기() {
        Point point = new Point(location, right);
        assertThat(point.isRight()).isTrue();

        point = new Point(location, left);
        assertThat(point.isRight()).isFalse();
    }

    @Test
    public void 입력한좌표값이_현재좌표값인지_확인하기() {
        int x = 1;
        int y = 2;
        Location location = new Location(x, y);

        Point point = new Point(location, right);

        assertThat(point.isLocationXY(x, y)).isTrue();

        assertThat(point.isLocationXY(x, 1000)).isFalse();
        assertThat(point.isLocationXY(1000, y)).isFalse();
        assertThat(point.isLocationXY(1000, 1000)).isFalse();
    }

}