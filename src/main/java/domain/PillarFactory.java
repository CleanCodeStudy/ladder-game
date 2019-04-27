package domain;

import domain.direction.Direction;
import domain.direction.DirectionGenerator;
import domain.direction.RandomGenerator;
import dto.UserInputDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class PillarFactory {

    private static final int ZERO = 0;

    private List<String> names;
    private int height;

    public PillarFactory(UserInputDto inputDto) {
        this.names = inputDto.getNames();
        this.height = inputDto.getHeight();
    }

    public List<Pillar> createPillars() {
        int lastIdx = names.size() - 1;
        List<Pillar> pillars = new ArrayList<>();

        Pillar before = Pillar.getDownPillar(height);
        for (int idx = 0; idx <= lastIdx; idx++) {
            Pillar now = createOne(names.get(idx), height);
            before = syncBefore(before, now);
            idx = syncIdx(idx, now);
            addPillar(pillars, now);
        }
        changeLastPillar(pillars.get(lastIdx));

        return pillars;
    }

    public Pillar createOne(String name, int height) {
        DirectionGenerator generator = new RandomGenerator(height);
        return new Pillar(new User(name), generator);
    }

    public Pillar syncBefore(Pillar before, Pillar now) {
        List<Direction> beforeDirections = before.getDirections();

        IntStream.range(0, before.getHeight())
                .filter(idx -> beforeDirections.get(idx).isRight())
                .forEach(idx -> now.changeDirection(idx, Direction.LEFT));

        return getPillar(before, now);
    }

    public int syncIdx(int now, Pillar pillar) {
        if (pillar.getRightAmount() == ZERO) {
            return now - 1;
        }
        return now;
    }

    public Pillar getPillar(Pillar before, Pillar now) {
        if (now.getRightAmount() == ZERO) {
            return before;
        }
        return now;
    }

    public void addPillar(List<Pillar> pillars, Pillar now) {
        if (now.getRightAmount() != ZERO) {
            pillars.add(now);
        }
    }

    private void changeLastPillar(Pillar pillar) {
        List<Direction> directions = pillar.getDirections();

        IntStream.range(0, directions.size())
                .boxed()
                .filter(height -> directions.get(height).isRight())
                .forEach(height -> pillar.changeDirection(height, Direction.DOWN));
    }

}
