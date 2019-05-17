package domain.converter;

import domain.ladder.Ladder;
import dto.GameStartOption;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OutputConverterTest {

    @Test
    public void Height에_따른_Level_생성() {
        GameStartOption gameStartOption = GameStartOption.of("pobi,honux,crong,jk", 10, "꽝,5000,꽝,3000");
        Ladder ladder = Ladder.of(gameStartOption);

        assertEquals(OutputConverter.of(ladder).getRows().size(), 10);
    }
}