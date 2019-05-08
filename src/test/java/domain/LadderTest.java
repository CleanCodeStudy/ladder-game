package domain;

import dto.GameInformationDto;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class LadderTest {
    @Test
    public void 높이_2_사다리_만들기() {
        //given
        Point leftPoint = Point.createRightLinkedPoint(1);
        Point rightPoint = Point.createLeftLinkedPoint(2);
        Bridge firstBridge = new Bridge(1, Arrays.asList(leftPoint,rightPoint));

        leftPoint = Point.createNotLinkedPoint(1);
        rightPoint = Point.createNotLinkedPoint(2);
        Bridge secondBridge = new Bridge(2,Arrays.asList(leftPoint,rightPoint));

        Ladder ladder = new Ladder(2,2,Arrays.asList(firstBridge,secondBridge));
        //when
        //then
    }

    @Test
    public void 높이_3_플레이어_3_사다리_만들기() {
        //given
        GameInformationDto gameInformationDto = new GameInformationDto("aaa,ccc,bbb","30,꽝,30",3);
        Ladder ladder = Ladder.createLadder(gameInformationDto);
        //when
        //then
        assertThat(ladder.getLadderHeight()).isEqualTo(3);
        assertThat(ladder.getPlayerNumber()).isEqualTo(3);
    }
}