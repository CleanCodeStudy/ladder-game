package com.cys.ladder.domain.ladder;

import java.util.List;

public class Bridge {
    private Integer height;
    private List<Point> points;

    public Bridge(Integer height, List<Point> points) {
        this.height = height;
        this.points = points;
    }

    public List<Point> getPoints() {
        return points;
    }

    public Integer getHeight() {
        return height;
    }


    public int nextIndex(int start) {
        return points.stream()
                .filter(point -> point.isEqualToColumn(start))
                .findFirst()
                .orElseThrow(RuntimeException::new)
                .nextColumn();
    }
}
