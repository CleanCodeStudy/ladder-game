package com.cys.ladder.domain.ladder;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {
    private List<Bridge> bridges;

    public Ladder(List<Bridge> bridges) {
        this.bridges = bridges.stream()
                .sorted(Comparator.comparing(Bridge::getHeight))
                .collect(Collectors.toList());
    }

    public List<Bridge> getBridges() {
        return bridges;
    }

    public int searchDestination(int start) {
        for (Bridge bridge1 : bridges) {
            start = bridge1.nextIndex(start);
        }
        return start;
    }
}
