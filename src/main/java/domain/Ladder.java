package domain;

import java.util.List;

public class Ladder {

    private List<Pillar> pillars;

    public Ladder(PillarFactory factory) {
        this.pillars = factory.createPillars();
    }
}
