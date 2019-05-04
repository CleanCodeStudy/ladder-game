package com.cys.ladder.domain.endpoint;

import java.util.Arrays;
import java.util.List;

public class Endpoint {
    private List<String> users;
    private List<String> prizes;

    public Endpoint(String users, String prizes) {
        this.users = Arrays.asList(users.split(","));
        this.prizes = Arrays.asList(prizes.split(","));
        validateSize(this.users,this.prizes);
    }

    private void validateSize(List<String> users, List<String> prizes) {
        if(users.size() != prizes.size()){
            throw new IllegalArgumentException();
        }
    }

    public Integer getPlayerNum() {
        return users.size();
    }

    public UserCollection toEntityUsers(){
        return new UserCollection(users);
    }

    public PrizeCollection toEntityPrizes(){
        return new PrizeCollection(prizes);
    }
}
