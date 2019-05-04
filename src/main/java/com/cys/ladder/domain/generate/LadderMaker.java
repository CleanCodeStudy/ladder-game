package com.cys.ladder.domain.generate;

import com.cys.ladder.domain.*;

import java.util.ArrayList;
import java.util.List;

public class LadderMaker {

    private LadderMaker() {
    }

    public static Ladder generateLadder(LadderOption option){
        List<Bridge> bridges = new ArrayList<>();
        for (int i = 1; i <=option.getHeight(); i++) {
            bridges.add(new Bridge(option.getHeight(), generateLine(option.getPlayerNum())));
        }
        return new Ladder(bridges);
    }

    private static List<Point> generateLine(int playerNum) {
        return new LineMaker().generateLine(playerNum);
    }
}
