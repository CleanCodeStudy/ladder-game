package domain;

import java.util.Random;

public enum LinkedType {
    RIGHT,
    LEFT,
    NONE;

    public static LinkedType getRandomLinked(){
        return new Random().nextBoolean() ? LinkedType.RIGHT : LinkedType.NONE;
    }
}
