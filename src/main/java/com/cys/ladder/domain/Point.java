package com.cys.ladder.domain;

import com.cys.ladder.LinkedStatus;

public class Point {
    private Integer column;
    private LinkedStatus linkedStatus;

    public Point(LinkedStatus status) {
        this.column = 1;
        this.linkedStatus = status;
    }

    public Point(Integer column, LinkedStatus linkedStatus) {
        this.column = column;
        this.linkedStatus = linkedStatus;
    }

    public boolean isLinked() {
        return linkedStatus == LinkedStatus.RIGHT;
    }

    public int getColumn() {
        return column;
    }
}
