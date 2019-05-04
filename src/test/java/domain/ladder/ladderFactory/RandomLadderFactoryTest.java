package domain.ladder.ladderFactory;

import domain.ladder.Pillar;
import dto.UserInputDto;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomLadderFactoryTest {

    RandomLadderFactory factory;
    int people;
    int height;
    UserInputDto inputDto;

    @Before
    public void setUp() throws Exception {
        String names = "kim,lee,park,choi";
        height = 5;
        inputDto = new UserInputDto(names, height);
        people = inputDto.getNames().size();
        factory = new RandomLadderFactory(inputDto);
    }

    @Test
    public void 기둥_랜덤_만들기() {
        List<Pillar> pillars = factory.createPillars();

        assertThat(pillars.size()).isEqualTo(people);
    }

}