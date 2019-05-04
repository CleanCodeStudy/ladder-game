package com.cys.ladder.domain;

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
}
