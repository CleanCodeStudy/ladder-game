package domain;

import domain.generator.LadderGenerator;
import dto.GameInformationDto;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class LadderTest {
    @Test
    public void 높이_3_플레이어_3_사다리_만들기() {
        //given
        GameInformationDto gameInformationDto = new GameInformationDto("aaa,ccc,bbb","30,꽝,30",3);
        Ladder ladder = LadderGenerator.generate(gameInformationDto.getLadderHeight(),gameInformationDto.getPlayers().size());
        //when
        //then
        assertThat(ladder.getLadderHeight()).isEqualTo(3);
        assertThat(ladder.getPlayerNumber()).isEqualTo(3);
    }
}