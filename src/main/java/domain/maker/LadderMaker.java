package domain.maker;

import domain.factory.PillarFactory;
import domain.ladder.Pillar;
import dto.GameStartOption;

import java.util.ArrayList;
import java.util.List;

public class LadderMaker {

    private List<Pillar> pillars = new ArrayList<>();
    private PillarFactory pillarFactory = new PillarFactory();

    public List<Pillar> createLadder(GameStartOption gameStartOption) {
        Pillar previous = pillarFactory.createFirstPillar(gameStartOption);
        pillars.add(previous);
        for (int i = 1; i < gameStartOption.getLadderWidth(); i++) {
            Pillar now = pillarFactory.createNotFirstPillar(gameStartOption, previous);
            pillars.add(now);
            previous = now;
        }
        return new ArrayList<>(pillars);
    }
}
