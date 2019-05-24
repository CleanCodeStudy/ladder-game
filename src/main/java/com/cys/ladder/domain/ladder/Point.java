package com.cys.ladder.domain.ladder;

import com.cys.ladder.domain.LinkedStatus;

public class Point {
    private Integer column;
    private LinkedStatus linkedStatus;

    public Point(LinkedStatus status) {
        this.column = 0;
        this.linkedStatus = status;
    }

    public Point(Integer column, LinkedStatus linkedStatus) {
        this.column = column;
        this.linkedStatus = linkedStatus;
    }

    public int getColumn() {
        return column;
    }

    public boolean isRightLinked() {
        return linkedStatus == LinkedStatus.RIGHT;
    }

    public boolean isLeftLinked() {
        return linkedStatus == LinkedStatus.LEFT;
    }

    public boolean isEqualToColumn(int start) {
        return column == start;
    }

    public int nextColumn() {
        if (isRightLinked()) {
            return column + 1;
        }
        if (isLeftLinked()) {
            return column - 1;
        }
        return column;
    }
}
