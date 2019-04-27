package domain;

import domain.direction.DirectionGenerator;
import domain.direction.RandomGenerator;
import dto.UserInputDto;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PillarFactoryTest {

    PillarFactory factory;
    DirectionGenerator generator;
    int people;
    int height;
    UserInputDto inputDto;

    @Before
    public void setUp() throws Exception {
        String names = "kim,lee,park,choi";
        height = 5;
        inputDto = new UserInputDto(names, height);
        people = inputDto.getNames().size();
        factory = new PillarFactory(inputDto);

    }

    @Test
    public void 기둥_랜덤_만들기(){
        generator = new RandomGenerator(height);
        List<Pillar> pillars = factory.createPillars();

        showDirections(pillars);

        for (Pillar pillar : pillars) {
            int count = pillar.getDirections().size();
            assertThat(count).isEqualTo(height);
        }
    }

    public void showDirections(List<Pillar> pillars) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < pillars.size(); x++) {
                System.out.print(pillars.get(x).getDirections().get(y) + " ");
            }
            System.out.println();
        }
    }
}