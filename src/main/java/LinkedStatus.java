import java.util.Arrays;
import java.util.Random;

public enum LinkedStatus {
    RIGHT, LEFT, NONE;

    LinkedStatus() {
    }

    public static LinkedStatus ofStart() {
        return new Random().nextBoolean() ? RIGHT : NONE;
    }

    public static LinkedStatus ofLast(Point previous) {
        if (previous.isLinked()) {
            return NONE;
        }
        return new Random().nextBoolean() ? LEFT : NONE;
    }

    public static LinkedStatus ofRandom(Point previous) {
        if (previous.isLinked()) {
            return NONE;
        }

        return Arrays.stream(LinkedStatus.values())
                .findAny()
                .orElseThrow(RuntimeException::new);
    }
}
