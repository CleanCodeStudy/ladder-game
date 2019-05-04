package view;

import domain.ladder.Ladder;
import domain.ladder.ladderFactory.RandomLadderFactory;
import dto.UserInputDto;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputViewTest {

    String names;
    RandomLadderFactory factory;
    int people;
    int height;
    UserInputDto inputDto;
    Ladder ladder;
    OutputView outputView;

    @Before
    public void setUp() throws Exception {
        names = "take,my,horse,to,the,old,town,road";
        height = 10;
        inputDto = new UserInputDto(names, height);
        people = inputDto.getNames().size();
        factory = new RandomLadderFactory(inputDto);
        ladder = new Ladder(factory.createPillars(),height);
        outputView = new OutputView(ladder);
    }

    @Test
    public void 이름_가져오기() {
        List<String> names = ladder.getNames();
        assertThat(names).containsAll(names);
    }

    @Test
    public void 이름_출력하기() {
        outputView.showNames();
    }

    @Test
    public void 사다리_출력() {
        outputView.showLadder();
    }
}