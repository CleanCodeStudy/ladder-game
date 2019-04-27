package domain.direction;

import domain.direction.Direction;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest {
    Direction down;
    Direction left;
    Direction right;

    @Before
    public void setUp() {
        down = Direction.DOWN;
        left = Direction.LEFT;
        right = Direction.RIGHT;
    }


    @Test
    public void 방향_찾기_테스트() {
        List<Direction> directions = Arrays.asList(down, left, right);

        assertThat(Direction.findByCode(down.getCode())).isEqualTo(Direction.DOWN);
        assertThat(Direction.findByCode(left.getCode())).isEqualTo(Direction.LEFT);
        assertThat(Direction.findByCode(right.getCode())).isEqualTo(Direction.RIGHT);
    }
}