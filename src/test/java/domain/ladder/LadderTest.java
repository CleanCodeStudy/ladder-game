package domain.ladder;

import dto.GameStartOption;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LadderTest {

    @Test
    public void Ladder_생성하기_Pillar_리스트_생성하기() {
        GameStartOption gameStartOption = new GameStartOption("pobi,honux,crong,jk", 4, "꽝,5000,꽝,3000");
        Ladder ladder = Ladder.of(gameStartOption);

        assertEquals((int) ladder.getWidth(), ladder.getPillars().size());
    }

    @Test
    public void Pillar_NUM_에따라_찾기() {
        GameStartOption gameStartOption = new GameStartOption("pobi,honux,crong,jk", 4, "꽝,5000,꽝,3000");
        Ladder ladder = Ladder.of(gameStartOption);

        Pillar p = ladder.getPillarByNum(1);
        assertEquals((Integer) 1, p.getPillarNum());
    }
}