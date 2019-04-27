package domain.direction;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DownGeneratorTest {

    @Test
    public void 아래로만_5개짜리_방향값뭉치_만들기() {
        DirectionGenerator directionGenerator = new DownGenerator(5);
        List<Direction> directions = directionGenerator.createDirections();

        assertThat(directions.size()).isEqualTo(5);

        assertThat(directions).containsOnly(Direction.DOWN);
    }
}