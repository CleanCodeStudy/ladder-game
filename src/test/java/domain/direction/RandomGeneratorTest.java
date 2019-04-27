package domain.direction;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomGeneratorTest {

    Direction down;
    Direction right;
    Direction left;

    @Before
    public void setUp(){
        down =Direction.DOWN;
        right =Direction.RIGHT;
        left =Direction.LEFT;
    }

    @Test
    public void 오른쪽_아래_5개_방향뭉치_만들기() {
        int size = 5;
        DirectionGenerator directionGenerator = new RandomGenerator(size);
        List<Direction> directions = directionGenerator.createDirections();

        assertThat(directions.size()).isEqualTo(size);

        directions.stream()
                .forEach(direction -> System.out.println(direction));
        assertThat(directions).containsAnyElementsOf(Arrays.asList(down,right,left));
    }
}