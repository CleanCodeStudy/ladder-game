package com.cys.ladder;

import com.cys.ladder.domain.Point;

import java.util.Random;

public enum LinkedStatus {
    RIGHT, LEFT, NONE;

    LinkedStatus() {
    }
    
    public static LinkedStatus ofStart() {
        return new Random().nextBoolean() ? RIGHT : NONE;
    }

    public static LinkedStatus ofLast(Point previous) {
        return  previous.isLinked() ? LEFT : NONE;
    }

    public static LinkedStatus ofRandom(Point previous) {
        if (previous.isLinked()) {
            return LEFT;
        }

        return ofStart();
    }
}
