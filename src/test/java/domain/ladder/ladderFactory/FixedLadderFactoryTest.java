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
        String rewards = "꽝,5000,꽝,3000";
        inputDto = new UserInputDto(names, height, rewards);
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
            assertThat(first.getPointDirection(0, i)).isEqualTo(Direction.RIGHT);
        }
    }

    /**
     * 0 to 1/3, 1/3 to 2/3, 2/3 to height
     * ㅁㄴㅇㄹ
     * ㅏㅓㅣㅣ
     * ㅣㅣㅣㅣ
     * ㅏㅓㅣㅣ
     * ㅏㅓㅣㅣ
     * ㅏㅓㅣㅣ
     * ㅁㄴㅇㄹ
     */
    @Test
    public void 고정사다리_만들기_테스트() {
        List<Pillar> pillars = factory.createPillars();

        assertThat(pillars.get(0).getPointDirection(0, 0)).isEqualTo(Direction.RIGHT);
        assertThat(pillars.get(1).getReward()).isEqualTo("5000");
        assertThat(pillars.get(1).getPointDirection(1, 0)).isEqualTo(Direction.LEFT);
        assertThat(pillars.get(1).getPointDirection(1, 4)).isEqualTo(Direction.LEFT);
    }
}