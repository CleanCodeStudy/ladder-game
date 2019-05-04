package util;

public enum LinkedType {
    RIGHT(1),
    LEFT(-1),
    NONE(0);

    private int moveValue;

    LinkedType(int moveValue) {
        this.moveValue = moveValue;
    }

    public int getMoveValue() {
        return moveValue;
    }
}
