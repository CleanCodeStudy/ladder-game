package com.cys.ladder;

import com.cys.ladder.domain.endpoint.Endpoint;
import com.cys.ladder.domain.ladder.Ladder;
import com.cys.ladder.domain.generate.LadderMaker;
import com.cys.ladder.domain.generate.LadderOption;
import com.cys.ladder.domain.generate.LineMaker;
import com.cys.ladder.view.InputView;
import com.cys.ladder.view.OutView;

public class LadderApplication {
    public static void main(String[] args) {
        Endpoint endpoint = InputView.inputEndPoint();
        LadderOption option = new LadderOption(InputView.inputHeight(), endpoint.getPlayerNum());

        OutView.draw(makeLadder(option),endpoint.toEntityPrizes(),endpoint.toEntityUsers());
    }

    private static Ladder makeLadder(LadderOption option){
        LineMaker lineMaker = new LineMaker();
        LadderMaker ladderMaker = new LadderMaker(lineMaker);
        return ladderMaker.generateLadder(option);
    }


}
