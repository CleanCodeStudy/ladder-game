package domain.LadderFactory;

import domain.Pillar;
import domain.Point;
import domain.direction.Direction;
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

        for (Pillar pillar : pillars) {
            int count = pillar.getPoints().size();
            assertThat(count).isEqualTo(height);
        }

        Pillar first = pillars.stream()
                .filter(pillar -> pillar.isEqualToX(0))
                .findFirst()
                .orElseThrow(RuntimeException::new);

        List<Point> points = first.getPoints();


        for (int i = 0; i < height / 3; i++) {
            assertThat(points.get(i).getDirection()).isEqualTo(Direction.RIGHT);
        }
        for (int i = height / 3; i < height / 3 * 2; i++) {
            assertThat(points.get(i).getDirection()).isEqualTo(Direction.DOWN);
        }
        for (int i = height / 3 * 2; i < height; i++) {
            assertThat(points.get(i).getDirection()).isEqualTo(Direction.LEFT);
        }
    }
}