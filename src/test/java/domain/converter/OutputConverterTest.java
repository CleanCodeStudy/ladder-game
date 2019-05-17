package domain.converter;

import domain.ladder.Ladder;
import dto.GameStartOption;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OutputConverterTest {

    @Test
    public void Height에_따른_Level_생성() {
        GameStartOption gameStartOption = new GameStartOption("pobi,honux,crong,jk", 10);
        Ladder ladder = Ladder.of(gameStartOption);

        assertEquals(OutputConverter.of(ladder).getRows().size(), 10);
    }
}