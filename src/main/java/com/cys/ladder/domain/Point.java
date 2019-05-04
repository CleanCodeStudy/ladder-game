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

    public boolean isRightLinked(){
        return linkedStatus == LinkedStatus.RIGHT;
    }

    public boolean isLinked() {
        return linkedStatus == LinkedStatus.RIGHT || linkedStatus == LinkedStatus.LEFT;
    }

    public int getColumn() {
        return column;
    }

    public boolean isLast(int playerNum) {
        return column + 1 == playerNum;
    }
}
