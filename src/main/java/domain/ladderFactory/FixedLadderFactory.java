package domain.ladderFactory;

import domain.direction.Direction;
import domain.ladder.*;
import dto.UserInputDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FixedLadderFactory implements LadderFactory {

    private List<String> names;
    private int height;

    public FixedLadderFactory(UserInputDto inputDto) {
        this.names = inputDto.getNames();
        this.height = inputDto.getHeight();
    }

    public List<Pillar> createPillars() {
        List<Pillar> pillars = new ArrayList<>();
        pillars.add(createFixedFirstPillar());
        addMid(pillars);
        pillars.add(Pillar.createLast(names.get(getLastIndex()), pillars.get(getLastIndex() - 1)));
        return pillars;
    }

    public Pillar createFixedFirstPillar() {
        List<Location> locations = getLocations();
        List<Point> points = new ArrayList<>();
        points.addAll(getRightPoints(locations));
        points.addAll(getDownPoints(locations));
        points.addAll(getLeftPoints(locations));
        return new Pillar(new User(names.get(0)), points);
    }

    private List<Location> getLocations() {
        return IntStream.range(0, height)
                .mapToObj(y -> new Location(0, y))
                .collect(Collectors.toList());
    }

    private List<Point> getRightPoints(List<Location> locations) {
        return IntStream.range(0, height / 3)
                .mapToObj(idx -> new Point(locations.get(idx), Direction.RIGHT))
                .collect(Collectors.toList());
    }

    private List<Point> getDownPoints(List<Location> locations) {
        return IntStream.range(height / 3, (height / 3) * 2)
                .mapToObj(idx -> new Point(locations.get(idx), Direction.DOWN))
                .collect(Collectors.toList());
    }

    private List<Point> getLeftPoints(List<Location> locations) {
        return IntStream.range((height / 3) * 2, height)
                .mapToObj(idx -> new Point(locations.get(idx), Direction.LEFT))
                .collect(Collectors.toList());
    }

    public void addMid(List<Pillar> pillars) {
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
