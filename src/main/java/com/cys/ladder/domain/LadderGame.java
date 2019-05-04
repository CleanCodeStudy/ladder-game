package com.cys.ladder.domain;

import com.cys.ladder.domain.ladder.Ladder;

public class LadderGame {
    private Ladder ladder;

    public LadderGame(Ladder ladder) {
        this.ladder = ladder;
    }

    public Ladder getLadder() {
        return ladder;
    }

}
