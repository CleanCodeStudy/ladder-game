package domain.ladder;

import domain.ladder.ladderFactory.FixedLadderFactory;
import domain.ladder.ladderFactory.LadderFactory;
import domain.ladder.ladderResult.LadderResult;
import dto.UserInputDto;
import org.junit.Before;
import org.junit.Test;
import view.OutputView;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderResultTest {

    String names;
    LadderFactory factory;
    int people;
    int height;
    UserInputDto inputDto;
    Ladder ladder;
    OutputView outputView;
    LadderResult ladderResult;

    @Before
    public void setUp() throws Exception {
        names = "take,my,horse,to,the,old,town,road";
        String rewards = "1,2,3,4,5,6,7,8";
        height = 10;
        inputDto = new UserInputDto(names, height, rewards);
        people = inputDto.getNames().size();
        factory = new FixedLadderFactory(inputDto);
        ladder = new Ladder(factory.createPillars(), height);
        ladderResult = ladder.start();
        outputView = new OutputView(ladder, ladderResult);
        outputView.showLadder();
    }

    @Test
    public void 개인_결과_구하기() {
        String take = "take";
        String my = "my";
        String horse = "horse";

        assertThat(ladderResult.findRewardByName(take)).isEqualTo("2");
        assertThat(ladderResult.findRewardByName(my)).isEqualTo("1");
        assertThat(ladderResult.findRewardByName(horse)).isEqualTo("3");
    }
}