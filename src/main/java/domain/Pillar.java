package domain;

import domain.direction.Direction;
import domain.direction.DirectionGenerator;
import domain.direction.FixedGenerator;

import java.util.List;

public class Pillar {

    private static final String DEFAULT_NAME = "default";

    private User user;
    private List<Direction> directions;

    private Pillar(DirectionGenerator generator) {
        this.user = new User(DEFAULT_NAME);
        this.directions = generator.createDirections();
    }

    public Pillar(User user, DirectionGenerator generator) {
        this.user = user;
        this.directions = generator.createDirections();
    }

    public String getUserName() {
        return user.getName();
    }

    public int getHeight() {
        return directions.size();
    }

    public List<Direction> getDirections() {
        return directions;
    }

    public int getRightAmount() {
        return (int) this.directions.stream()
                .filter(Direction::isRight)
                .count();
    }

    public static Pillar getDownPillar(int height) {
        return new Pillar(new FixedGenerator(height));
    }

    public void changeDirection(int idx, Direction direction) {
        this.directions.set(idx, direction);
    }
}
