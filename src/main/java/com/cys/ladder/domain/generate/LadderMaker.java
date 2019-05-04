package com.cys.ladder.domain.generate;

import com.cys.ladder.domain.ladder.Bridge;
import com.cys.ladder.domain.ladder.Ladder;
import com.cys.ladder.domain.ladder.Point;

import java.util.ArrayList;
import java.util.List;

public class LadderMaker {
    private LineMaker lineMaker;

    public LadderMaker(LineMaker lineMaker) {
        this.lineMaker = lineMaker;
    }

    public Ladder generateLadder(LadderOption option){
        List<Bridge> bridges = new ArrayList<>();
        final int height = option.getHeight();

        for (int i = 1; i <= height; i++) {
            List<Point> line  = lineMaker.generateLine(option.getPlayerNum());
            bridges.add(new Bridge(height, line));
        }

        return new Ladder(bridges);
    }

}
