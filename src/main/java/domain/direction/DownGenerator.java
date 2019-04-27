package domain.direction;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DownGenerator implements DirectionGenerator {

    private int height;

    public DownGenerator(int height) {
        this.height = height;
    }

    @Override
    public List<Direction> createDirections() {
        return IntStream.rangeClosed(1, height)
                .mapToObj(each -> Direction.DOWN)
                .collect(Collectors.toList());
    }
}
