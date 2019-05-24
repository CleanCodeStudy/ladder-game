package com.cys.ladder.domain.endpoint;

import java.util.ArrayList;
import java.util.List;

public class PrizeCollection {
    private List<Prize> prizes = new ArrayList<>();

    public PrizeCollection(List<String> prizes) {
        addPrize(prizes);
    }

    private void addPrize(List<String> prizes) {
        for (int i = 0; i < prizes.size(); i++) {
            Prize prize = new Prize(prizes.get(i), i + 1);
            this.prizes.add(prize);
        }
    }

    public List<Prize> getPrizes() {
        return new ArrayList<>(prizes);
    }

    public Prize getPrize(int end) {
        return prizes.get(end);
    }
}