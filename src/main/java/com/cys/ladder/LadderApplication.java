package com.cys.ladder;

import com.cys.ladder.domain.Endpoint;
import com.cys.ladder.domain.generate.LadderMaker;
import com.cys.ladder.domain.generate.LadderOption;
import com.cys.ladder.view.InputView;
import com.cys.ladder.view.OutView;

public class LadderApplication {
    public static void main(String[] args) {
        Endpoint endpoint = InputView.inputEndPoint();
        LadderOption option = new LadderOption(InputView.inputHeight(), endpoint.getPlayerNum());

        OutView.draw(LadderMaker.generateLadder(option),endpoint.toEntityPrizes(),endpoint.toEntityUsers());
    }



}
