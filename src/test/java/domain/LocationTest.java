package domain;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LocationTest {
    int beforeX;
    int beforeY;
    int expectX;
    int expectY;

    @Before
    public void setUp() throws Exception {
        beforeX = 1;
        beforeY = 1;
        expectX = 2;
        expectY = 1;
    }

    @Test
    public void 이전위치로_새로운위치_만들기() {
        Location before = new Location(beforeX, beforeY);
        Location now = new Location(before);

        assertThat(now.getX()).isEqualTo(expectX);
        assertThat(now.getY()).isEqualTo(expectY);
    }

    @Test
    public void X좌표_가져오기() {
        int x = 12;
        int y = 0;
        Location location = new Location(x, y);
        assertThat(location.getX()).isEqualTo(x);
    }

    @Test
    public void Y좌표_가져오기() {
        int x = 12;
        int y = 0;
        Location location = new Location(x, y);
        assertThat(location.getY()).isEqualTo(y);
    }

    @Test
    public void 입력한XY좌표값이_가지고있는_XY와동일한지() {
        int x = 10;
        int y = 20;
        Location location = new Location(x,y);

        assertThat(location.isEqual(x,y)).isTrue();

        assertThat(location.isEqual(0,y)).isFalse();
        assertThat(location.isEqual(x,0)).isFalse();
        assertThat(location.isEqual(0,0)).isFalse();
    }
}