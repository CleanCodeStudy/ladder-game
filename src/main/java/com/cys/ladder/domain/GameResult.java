package com.cys.ladder.domain;

import com.cys.ladder.domain.endpoint.Prize;
import com.cys.ladder.domain.endpoint.User;

import java.util.Map;

public class GameResult {
    private Map<User, Prize> results;

    public GameResult(Map<User, Prize> results) {
        this.results = results;
    }

    public Prize findByResult(String name){
        User target = results.keySet().stream()
                .filter(user->user.isEqualName(name))
                .findFirst()
                .orElseThrow(RuntimeException::new);
        return results.get(target);
    }

    public Map<User, Prize> getResults() {
        return results;
    }
}
