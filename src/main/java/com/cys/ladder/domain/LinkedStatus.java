package com.cys.ladder.domain;

import com.cys.ladder.domain.ladder.Point;

import java.util.Random;

public enum LinkedStatus {
    RIGHT, LEFT, NONE;

    LinkedStatus() {
    }
    
    public static LinkedStatus ofRandom() {
        return new Random().nextBoolean() ? RIGHT : NONE;
    }

    public static LinkedStatus ofPrevious(Point previous){
        if(previous.isRightLinked()){
            return LinkedStatus.LEFT;
        }

        if(previous.isLeftLinked()){
            return LinkedStatus.RIGHT;
        }

        return ofRandom();
    }

    public static LinkedStatus createLastLink(Point previous) {
        return  previous.isRightLinked() ? LEFT : NONE;
    }
}
