package domain.direction;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FixedGeneratorTest {

    @Test
    public void 아래방향만_존재하는_방향_5개생성() {
        int size = 5;

        DirectionGenerator generator = new FixedGenerator(5);
        List<Direction> directions = generator.createDirections();

        assertThat(directions.size()).isEqualTo(size);
        assertThat(directions).containsOnly(Direction.DOWN);
    }
}