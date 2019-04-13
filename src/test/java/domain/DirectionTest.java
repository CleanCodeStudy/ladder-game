package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest {


    @Test
    public void 방향_찾기_테스트() {
        Direction down = Direction.DOWN;
        Direction left = Direction.LEFT;
        Direction right = Direction.RIGHT;

        assertThat(Direction.findByCode(down.getCode())).isEqualTo(Direction.DOWN);
        assertThat(Direction.findByCode(left.getCode())).isEqualTo(Direction.LEFT);
        assertThat(Direction.findByCode(right.getCode())).isEqualTo(Direction.RIGHT);
    }
}