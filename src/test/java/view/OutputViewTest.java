package view;

import domain.ladder.Ladder;
import domain.ladder.ladderFactory.FixedLadderFactory;
import domain.ladder.ladderFactory.LadderFactory;
import domain.ladder.ladderFactory.RandomLadderFactory;
import domain.ladder.ladderResult.LadderResult;
import dto.UserInputDto;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputViewTest {

    String names;
    LadderFactory factory;
    int people;
    int height;
    UserInputDto inputDto;
    Ladder ladder;
    OutputView outputView;

    @Before
    public void setUp() throws Exception {
        names = "take,my,horse,to,the,old,town,road";
        String rewards = "꽝,5000,꽝,3000,꽝,3000,꽝,3000";
        height = 10;
        inputDto = new UserInputDto(names, height, rewards);
        people = inputDto.getNames().size();
        factory = new RandomLadderFactory(inputDto);
        ladder = new Ladder(factory.createPillars(), height);
        LadderResult ladderResult = ladder.start();

        outputView = new OutputView(ladder, ladderResult);
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

    @Test
    public void 고정사다리_출력() {
        factory = new FixedLadderFactory(inputDto);
        ladder = new Ladder(factory.createPillars(), height);
        outputView = new OutputView(ladder, ladder.start());

        outputView.showLadder();
    }

    @Test
    public void 지목한대상_결과_출력() {
        factory = new FixedLadderFactory(inputDto);
        ladder = new Ladder(factory.createPillars(), height);
        outputView = new OutputView(ladder, ladder.start());

        outputView.showLadder();

        String take = "take";
        outputView.showResult(take);
    }

    @Test
    public void 전체결과출력() {
        factory = new FixedLadderFactory(inputDto);
        ladder = new Ladder(factory.createPillars(), height);
        outputView = new OutputView(ladder, ladder.start());

        outputView.showLadder();

        String all = "all";
        outputView.showResult(all);
    }
}