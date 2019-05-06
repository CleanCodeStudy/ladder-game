package domain.ladder.ladderFactory;

import domain.direction.Direction;
import domain.ladder.*;
import dto.UserInputDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FixedLadderFactory implements LadderFactory {

    private List<TopAndBottom> topAndBottoms;
    private int height;

    public FixedLadderFactory(UserInputDto inputDto) {
        this.topAndBottoms = inputDto.toEntities();
        this.height = inputDto.getHeight();
    }

    public List<Pillar> createPillars() {
        List<Pillar> pillars = new ArrayList<>();
        addFixedFirstPillar(pillars);
        addFixedMidPillar(pillars);
        addFixedLastPillar(pillars);
        return pillars;
    }

    private void addFixedFirstPillar(List<Pillar> pillars) {
        pillars.add(createFixedIndexPillar(0));
    }

    private Pillar createFixedIndexPillar(int index) {
        List<Location> locations = getLocations(index);
        List<Point> points = new ArrayList<>();
        points.addAll(createTopFixedPoints(locations, Direction.RIGHT));
        points.addAll(createMidFixedPoints(locations, Direction.DOWN));
        points.addAll(createBottomFixedPoints(locations, Direction.RIGHT));
        return new Pillar(topAndBottoms.get(index), points);
    }

    private void addFixedMidPillar(List<Pillar> pillars) {
        pillars.add(createFixedPillarByIdx(1));
        for (int i = 2; i < topAndBottoms.size() - 1; i++) {
            pillars.add(createFixedPillarByIdx(i));
        }
    }

    private Pillar createFixedPillarByIdx(int idx) {
        List<Location> locations = getLocations(idx);
        List<Point> points = new ArrayList<>();
        if (idx == 1) {
            createSecondPoints(locations, points);
            return new Pillar(topAndBottoms.get(idx), points);
        }
        createOnlyDownPoints(locations, points);
        return new Pillar(topAndBottoms.get(idx), points);
    }

    private void createSecondPoints(List<Location> locations, List<Point> points) {
        points.addAll(createTopFixedPoints(locations, Direction.LEFT));
        points.addAll(createMidFixedPoints(locations, Direction.DOWN));
        points.addAll(createBottomFixedPoints(locations, Direction.LEFT));
    }

    private void addFixedLastPillar(List<Pillar> pillars) {
        pillars.add(createFixedPillarByIdx(getLastIndex()));
    }

    private void createOnlyDownPoints(List<Location> locations, List<Point> points) {
        points.addAll(createTopFixedPoints(locations, Direction.DOWN));
        points.addAll(createMidFixedPoints(locations, Direction.DOWN));
        points.addAll(createBottomFixedPoints(locations, Direction.DOWN));
    }

    private List<Location> getLocations(int x) {
        return IntStream.range(0, height)
                .mapToObj(y -> new Location(x, y))
                .collect(Collectors.toList());
    }

    private List<Point> createTopFixedPoints(List<Location> locations, Direction direction) {
        return IntStream.range(0, height / 3)
                .mapToObj(idx -> new Point(locations.get(idx), direction))
                .collect(Collectors.toList());
    }

    private List<Point> createMidFixedPoints(List<Location> locations, Direction direction) {
        return IntStream.range(height / 3, (height / 3) * 2)
                .mapToObj(idx -> new Point(locations.get(idx), direction))
                .collect(Collectors.toList());
    }

    private List<Point> createBottomFixedPoints(List<Location> locations, Direction direction) {
        return IntStream.range((height / 3) * 2, height)
                .mapToObj(idx -> new Point(locations.get(idx), direction))
                .collect(Collectors.toList());
    }

    private int getLastIndex() {
        return topAndBottoms.size() - 1;
    }

    public Ladder createLadder() {
        return new Ladder(createPillars(), height);
    }
}
