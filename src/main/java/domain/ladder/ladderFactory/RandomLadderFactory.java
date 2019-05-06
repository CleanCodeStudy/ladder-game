package domain.ladder.ladderFactory;

import domain.ladder.Ladder;
import domain.ladder.Pillar;
import domain.ladder.TopAndBottom;
import dto.UserInputDto;

import java.util.ArrayList;
import java.util.List;

public class RandomLadderFactory implements LadderFactory {

    private List<TopAndBottom> topAndBottoms;
    private int height;

    public RandomLadderFactory(UserInputDto inputDto) {
        this.topAndBottoms = inputDto.toEntities();
        this.height = inputDto.getHeight();
    }

    @Override
    public List<Pillar> createPillars() {
        List<Pillar> pillars = new ArrayList<>();
        addFirst(pillars);
        addMid(pillars);
        addLast(pillars);
        return pillars;
    }

    private void addFirst(List<Pillar> pillars) {
        pillars.add(Pillar.createFirst(topAndBottoms.get(0), height));
    }

    private void addMid(List<Pillar> pillars) {
        for (int i = 1; i < topAndBottoms.size() - 1; i++) {
            Pillar pillar = Pillar.createMiddle(topAndBottoms.get(i), pillars.get(i - 1));
            pillars.add(pillar);
        }
    }

    private void addLast(List<Pillar> pillars) {
        pillars.add(Pillar.createLast(topAndBottoms.get(getLastIndex()), pillars.get(getLastIndex() - 1)));
    }

    private int getLastIndex() {
        return topAndBottoms.size() - 1;
    }

    public Ladder createLadder() {
        return new Ladder(createPillars(), height);
    }
}
