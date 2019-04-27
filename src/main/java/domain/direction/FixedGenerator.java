package domain.direction;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FixedGenerator implements DirectionGenerator {

    private int height;

    public FixedGenerator(int height) {
        this.height = height;
    }

    @Override
    public List<Direction> createDirections() {

        return IntStream.range(0, height)
                .boxed()
                .map(each -> Direction.DOWN)
                .collect(Collectors.toList());
    }
}
