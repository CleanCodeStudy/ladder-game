package domain.ladder;

import data.InputData;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private List<Pillar> pillars;
    private Integer width;
    private Integer height;

    public Ladder(InputData inputData) {
        this.width = inputData.getLadderWidth();
        this.height = inputData.getLadderHeight();
        this.pillars = createLadder(inputData);
    }

    private List<Pillar> createLadder(InputData inputData) {
        List<Pillar> pillars = new ArrayList<>();
        Pillar previous = new Pillar(inputData, null);
        pillars.add(previous);
        for (int i = 1; i < width; i++) {
            Pillar now = new Pillar(inputData, previous);
            pillars.add(now);
            previous = now;
        }
        return pillars;
    }

    public Pillar getPillarByNum(Integer pillarNum) {
        return pillars.stream()
                .filter(p -> p.getPillarNum() == pillarNum)
                .findFirst()
                .orElse(null);
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

}
