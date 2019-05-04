package com.cys.ladder.domain;

public class Prize {
    private String prize;
    private Integer location;

    public Prize(String prize, Integer location) {
        this.prize = prize;
        this.location = location+1;
    }

    public String getPrize() {
        return prize;
    }
}
