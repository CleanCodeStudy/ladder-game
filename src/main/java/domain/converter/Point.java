package domain.converter;

import domain.ladder.Bridge;

import java.util.Optional;

public class Point implements Comparable<Point> {
    private Integer pillarNum;
    private Bridge bridge;

    private Point(Integer pillarNum, Bridge bridge) {
        this.pillarNum = pillarNum;
        this.bridge = bridge;
    }

    private Point(Integer pillarNum) {
        this.pillarNum = pillarNum;
    }

    public static Point of(Integer pillarNum, Optional<Bridge> bridge) {
        if (bridge.isPresent())
            return new Point(pillarNum, bridge.get());
        return new Point(pillarNum);
    }

    public boolean isBlankPoint() {
        return bridge == null;
    }

    @Override
    public String toString() {
        return "pillarNum:" + pillarNum + "/" + "bridge:" + bridge.getLocation();
    }

    public Integer getPillarNum() {
        return pillarNum;
    }

    public Bridge getBridge() {
        return bridge;
    }

    @Override
    public int compareTo(Point o) {
        return pillarNum.compareTo(o.pillarNum);
    }
}
