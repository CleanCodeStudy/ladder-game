package domain;

import domain.ladder.Ladder;
import domain.ladderFactory.FixedLadderFactory;
import domain.ladderFactory.LadderFactory;
import domain.direction.Direction;
import dto.UserInputDto;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    Ladder ladder;

    LadderFactory factory;
    int height;
    UserInputDto inputDto;
    String names;

    @Before
    public void setUp() throws Exception {
        names = "kim,lee,park,choi";
        height = 5;
        inputDto = new UserInputDto(names, height);
        factory = new FixedLadderFactory(inputDto);
        ladder = ((FixedLadderFactory) factory).createLadder();
    }

    @Test
    public void 높이값_가져오기() {
        assertThat(ladder.getHeight()).isEqualTo(height);
    }

    @Test
    public void 참여자_목록_가져오기() {
        assertThat(ladder.getNames()).containsAll(Arrays.asList(names.split(",")));
    }

    @Test
    public void 좌표에_맞는_방향가져오기() {
        assertThat(ladder.getDirection(0, 0)).isEqualTo(Direction.RIGHT);
        assertThat(ladder.getDirection(0, height / 3)).isEqualTo(Direction.DOWN);
        assertThat(ladder.getDirection(0, height - 1)).isEqualTo(Direction.LEFT);
    }
}