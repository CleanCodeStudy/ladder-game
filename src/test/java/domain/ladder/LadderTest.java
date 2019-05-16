package domain.ladder;

import dto.GameStartOption;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LadderTest {

    @Test
    public void Ladder_생성하기_Pillar_리스트_생성하기() {
        GameStartOption gameStartOption = new GameStartOption("pobi,honux,crong,jk", 4);
        Ladder ladder = Ladder.of(gameStartOption);

        assertEquals((int) ladder.getWidth(), ladder.getPillars().size());
    }

    @Test
    public void Pillar_NUM_에따라_찾기() {
        GameStartOption gameStartOption = new GameStartOption("pobi,honux,crong,jk", 4);
        Ladder ladder = Ladder.of(gameStartOption);

        Pillar p = ladder.getPillarByNum(1);
        assertEquals((Integer) 1, p.getPillarNum());
    }

//        @Test
//    public void 이전기둥불러오기_left_pillar() {
//        InputData inputData = new InputData(3,4);
//        Ladder ladder = new Ladder(inputData);
//        Pillar now = ladder.getPillars().get(2);
//            System.out.println(now.getPillarNum());
//        assertEquals(0, ladder.getPreviousPillar(now));
//        assertEquals(2, ladder.getNextPillar(now));
//    }

//    @Test
//    public void 이전기둥이_유효하지_않을때_체크하기() {
//        Pillar pillar = new Pillar(1);
////        Pillar previous = pillar.getPreviousPillar();
//        assertEquals(null, previous);
//
//    }

}