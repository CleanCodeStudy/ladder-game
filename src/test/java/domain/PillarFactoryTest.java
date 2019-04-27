package domain;

import domain.direction.Direction;
import domain.direction.DirectionGenerator;
import domain.direction.DownGenerator;
import domain.direction.RandomGenerator;
import dto.UserInputDto;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PillarFactoryTest {

    PillarFactory factory;
    DirectionGenerator directionGenerator;
    int people;
    int height;
    UserInputDto inputDto;

    @Before
    public void setUp() throws Exception {
        String names = "kim,lee,park";
        height = 5;
        inputDto = new UserInputDto(names, height);
        people = inputDto.getNames().size();
        factory = new PillarFactory(inputDto);
    }

    @Test
    public void 입력값에_기반하여_기둥들_만들기() {
        directionGenerator = new DownGenerator(height);
        List<Pillar> pillars = factory.createPillar(directionGenerator);

        int pillarCount = (int) pillars.stream()
                .filter(pillar -> pillar.getHeight() == height)
                .count();
        assertThat(pillarCount).isEqualTo(people);
    }

    @Test
    public void 기둥방향_전부_아래로만_만들기() {
        directionGenerator = new DownGenerator(height);
        List<Pillar> pillars = factory.createPillar(directionGenerator);

        for (Pillar pillar : pillars) {
            int downCount = (int) pillar.getDirections().stream()
                    .filter(direction -> direction == Direction.DOWN)
                    .count();
            assertThat(downCount).isEqualTo(height);
        }
    }

    @Test
    public void 기둥방향_오른쪽하고_아래로만_만들기() {
        directionGenerator = new RandomGenerator(height);
        List<Pillar> pillars = factory.createPillar(directionGenerator);

        for (Pillar pillar : pillars) {
            int downCount = (int) pillar.getDirections().stream()
                    .filter(direction -> 1 <= direction.getCode() && direction.getCode() <= 3)
                    .count();
            pillar.getDirections().stream().forEach(direction -> System.out.println(direction));
            System.out.println();
            assertThat(downCount).isEqualTo(height);
        }
    }
}