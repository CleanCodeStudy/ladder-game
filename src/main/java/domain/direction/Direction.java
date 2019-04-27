package domain.direction;

import java.util.Arrays;

public enum Direction {
    LEFT(1),
    RIGHT(2),
    DOWN(3);

    private int code;

    Direction(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static Direction findByCode(int code) {
        return Arrays.stream(Direction.values())
                .filter(direction -> direction.hasCode(code))
                .findFirst()
                .orElse(DOWN);
    }

    private boolean hasCode(int code) {
        return this.code == code;
    }
}
