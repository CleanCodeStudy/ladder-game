package domain.maker;

import domain.ladder.Pillar;
import dto.GameStartOption;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class LadderMakerTest {

    @Test
    public void LadderMaker로_Ladder안에있는_PillarList_만들기() {
        GameStartOption gameStartOption = new GameStartOption("pobi,honux,crong,jk", 3);
        LadderMaker ladderMaker = new LadderMaker();
        List<Pillar> pillarList = ladderMaker.createLadder(gameStartOption);
        assertEquals(4, pillarList.size());
    }
}