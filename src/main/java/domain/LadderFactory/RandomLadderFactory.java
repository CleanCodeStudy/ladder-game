package domain.LadderFactory;

import domain.Ladder;
import domain.Pillar;
import dto.UserInputDto;

import java.util.ArrayList;
import java.util.List;

public class RandomLadderFactory implements LadderFactory {

    private List<String> names;
    private int height;

    public RandomLadderFactory(UserInputDto inputDto) {
        this.names = inputDto.getNames();
        this.height = inputDto.getHeight();
    }

    @Override
    public List<Pillar> createPillars() {
        List<Pillar> pillars = new ArrayList<>();
        pillars.add(Pillar.createFirst(names.get(0), height));
        addMid(pillars);
        pillars.add(Pillar.createLast(names.get(getLastIndex()), pillars.get(getLastIndex() - 1)));
        return pillars;
    }

    private void addMid(List<Pillar> pillars) {
        for (int i = 1; i < names.size() - 1; i++) {
            Pillar pillar = Pillar.createMiddle(names.get(i), pillars.get(i - 1));
            pillars.add(pillar);
        }
    }

    private int getLastIndex() {
        return names.size() - 1;
    }

    public Ladder createLadder() {
        return new Ladder(createPillars());
    }
}
