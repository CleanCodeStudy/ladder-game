package domain.converter;

import domain.ladder.Ladder;

import java.util.List;
import java.util.stream.Collectors;

public class Row implements Comparable<Row> {
    private Integer location;
    private List<Point> points;

    private Row(Integer location, Ladder ladder) {
        this.location = location;
        this.points = findLocationBridge(ladder);
    }

    public static Row of(Integer location, Ladder ladder) {
        return new Row(location, ladder);
    }

    private List<Point> findLocationBridge(Ladder ladder) {
        return ladder.getPillars().stream()
                .map(pillar -> Point.of(pillar.getPillarNum(), pillar.getLevelBridges(location)))
                .collect(Collectors.toList());
    }

    public Integer getLocation() {
        return location;
    }

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public int compareTo(Row o) {
        return location.compareTo(o.location);
    }
}