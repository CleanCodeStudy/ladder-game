package domain.ladderCalculator;

import domain.ladder.Ladder;
import dto.GameStartOption;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LadderIOTest {

    @Test
    public void 유저_리스트_관리하는_유저_관리자_생성하기() {
        GameStartOption gameStartOption = GameStartOption.of("pobi,honux,crong,jk", 4, "꽝,5000,꽝,3000");
        Ladder ladder = Ladder.of(gameStartOption);
        LadderIO ladderIO = LadderIO.of(gameStartOption);
        assertEquals(4, ladderIO.getUsers().size());
    }
}