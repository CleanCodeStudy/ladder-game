package domain.direction;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomGenerator implements DirectionGenerator {

    private static final int ANY = 0;
    private static final int DOWN = Direction.DOWN.getCode();
    private static final int RIGHT = Direction.RIGHT.getCode();
    private static final Map<Integer, Direction> RIGHT_AND_DOWN;

    static {
        RIGHT_AND_DOWN = getInstance();
    }

    int height;

    public RandomGenerator(int height) {
        this.height = height;
    }

    @Override
    public List<Direction> createDirections() {
        List<Direction> directions = IntStream.rangeClosed(1, height)
                .mapToObj(each -> createEach())
                .collect(Collectors.toList());
        return directions;
    }

    private static Direction createEach() {
        List<Integer> codes = RIGHT_AND_DOWN.keySet().stream()
                .collect(Collectors.toList());

        Collections.shuffle(codes);

        return Direction.findByCode(codes.get(ANY));
    }

    private static Map<Integer, Direction> getInstance() {
        return IntStream.rangeClosed(RIGHT,DOWN)
                .mapToObj(code -> Direction.findByCode(code))
                .collect(Collectors.toMap(Direction::getCode, Function.identity()));
    }


}
