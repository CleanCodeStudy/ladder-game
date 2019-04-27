package domain.direction;

import org.junit.Before;
import org.junit.Test;

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
    public void 오른쪽인지_확인() {
        assertThat(Direction.LEFT.isRight()).isFalse();
        assertThat(Direction.RIGHT.isRight()).isTrue();
    }

    @Test
    public void 방향_찾기_테스트() {
        assertThat(Direction.findByCode(down.getCode())).isEqualTo(Direction.DOWN);
        assertThat(Direction.findByCode(left.getCode())).isEqualTo(Direction.LEFT);
        assertThat(Direction.findByCode(right.getCode())).isEqualTo(Direction.RIGHT);
    }
}