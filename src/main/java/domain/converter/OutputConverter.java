package domain.converter;

import domain.ladder.Ladder;

import java.util.ArrayList;
import java.util.List;

public class OutputConverter {
    private List<Row> rows = new ArrayList<>();

    private OutputConverter(Ladder ladder) {
        for (int location = 0; location < ladder.getHeight(); location++) {
            rows.add(Row.of(location, ladder));
        }
    }

    public static OutputConverter of(Ladder ladder) {
        return new OutputConverter(ladder);
    }

    public List<Row> getRows() {
        return new ArrayList<>(rows);
    }


}
