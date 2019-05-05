package domain.ladder.ladderFactory;

import domain.direction.Direction;
import domain.ladder.Pillar;
import dto.UserInputDto;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FixedLadderFactoryTest {

    FixedLadderFactory factory;
    int people;
    int height;
    UserInputDto inputDto;

    @Before
    public void setUp() throws Exception {
        String names = "kim,lee,park,choi";
        height = 5;
        inputDto = new UserInputDto(names, height);
        people = inputDto.getNames().size();
        factory = new FixedLadderFactory(inputDto);
    }

    @Test
    public void 첫번째_기둥_고정된거_만들기() {
        List<Pillar> pillars = factory.createPillars();

        assertThat(pillars.size()).isEqualTo(people);

        Pillar first = pillars.get(0);

        for (int i = 0; i < height / 3; i++) {
            assertThat(first.getPointDirection(0, i)).isEqualTo(Direction.RIGHT);
        }
        for (int i = height / 3; i < height / 3 * 2; i++) {
            assertThat(first.getPointDirection(0, i)).isEqualTo(Direction.DOWN);
        }
        for (int i = height / 3 * 2; i < height; i++) {
            assertThat(first.getPointDirection(0, i)).isEqualTo(Direction.LEFT);
        }
    }
}