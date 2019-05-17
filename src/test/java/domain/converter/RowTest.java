package domain.converter;

import domain.ladder.Ladder;
import dto.GameStartOption;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RowTest {

    @Test
    public void location에_맞는_bridge_point_생성() {
        GameStartOption gameStartOption = new GameStartOption("pobi,honux,crong,jk", 4);
        Ladder ladder = Ladder.of(gameStartOption);

        Row row = Row.of(1, ladder);

        for (Point point : row.getPoints()) {
            if (!point.isBlankPoint()) {
                assertEquals((int) point.getBridge().getLocation(), 1);
            }
        }
    }

    @Test
    public void point와_bridge_Pillar_대응_확인() {
        GameStartOption gameStartOption = new GameStartOption("pobi,honux,crong,jk", 4);
        Ladder ladder = Ladder.of(gameStartOption);

        Row row = Row.of(1, ladder);

        for (Point point : row.getPoints()) {
            if (!point.isBlankPoint()) {
                Integer pointPillarNum = point.getPillarNum();
                boolean levelBridgesIsPresent = ladder.getPillarByNum(pointPillarNum).getLevelBridges(1).isPresent();
                assertEquals(true, levelBridgesIsPresent);
            }
        }
    }
}
