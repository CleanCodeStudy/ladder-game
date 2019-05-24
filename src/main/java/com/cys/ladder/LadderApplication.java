package com.cys.ladder;

import com.cys.ladder.domain.GameResult;
import com.cys.ladder.domain.LadderGame;
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

        Ladder ladder = makeLadder(option);
        OutView.draw(ladder, endpoint.toEntityPrizes(), endpoint.toEntityUsers());

        GameResult gameResult = new LadderGame(ladder).start(endpoint.toEntityUsers(), endpoint.toEntityPrizes());

        showGameResult(gameResult);
    }

    private static void showGameResult(GameResult gameResult) {
        while (true) {
            String name = InputView.inputName();
            OutView.drawResult(gameResult,name);
        }
    }

    private static Ladder makeLadder(LadderOption option) {
        LineMaker lineMaker = new LineMaker();
        LadderMaker ladderMaker = new LadderMaker(lineMaker);
        return ladderMaker.generateLadder(option);
    }


}
