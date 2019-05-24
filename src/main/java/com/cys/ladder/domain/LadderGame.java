package com.cys.ladder.domain;

import com.cys.ladder.domain.endpoint.Prize;
import com.cys.ladder.domain.endpoint.PrizeCollection;
import com.cys.ladder.domain.endpoint.User;
import com.cys.ladder.domain.endpoint.UserCollection;
import com.cys.ladder.domain.ladder.Ladder;

import java.util.HashMap;
import java.util.Map;

public class LadderGame {
    private Ladder ladder;

    public LadderGame(Ladder ladder) {
        this.ladder = ladder;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public GameResult start(UserCollection users, PrizeCollection prizes){
        Map<User, Prize> results = new HashMap<>();
        for (int start = 0; start < users.getSize() ; start++) {
            int end = ladder.searchDestination(start);
            results.put(users.getUser(start),prizes.getPrize(end));
        }
        return new GameResult(results);
    }

}
