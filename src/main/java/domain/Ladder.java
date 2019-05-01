package domain;

import data.InputData;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    public static final int MINIMUM_PILLAR_NUM = 1;
    private List<Pillar> pillars;
    private Integer width;
    private Integer height;

    public Ladder(InputData inputData) {
        this.width = inputData.getPillarCount();
        this.height = inputData.getLadderHeight();
        this.pillars = createLadder(inputData);
    }

    private List<Pillar> createLadder(InputData inputData) {
        List<Pillar> pillars = new ArrayList<>();
        Pillar previous = new Pillar(inputData, null);
        pillars.add(previous);
        for (int i = MINIMUM_PILLAR_NUM; i <= width - 1; i++) {
            Pillar now = new Pillar(inputData, previous);
            pillars.add(now);
            previous = now;
        }
        return pillars;
    }

    public List<Pillar> getPillars() {
        return pillars;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }

    public Pillar getPreviousPillar(Pillar pillar) {
        if (MINIMUM_PILLAR_NUM <= pillar.getPillarNum())
            return null;
        return pillars.stream()
                .filter(p -> p.getPillarNum() == pillar.getPillarNum() - 1)
                .findAny()
                .orElse(null);
    }

}
