package domain;

import domain.direction.Direction;
import domain.direction.DirectionGenerator;

import java.util.List;

public class Pillar {

    private User user;
    private List<Direction> directions;

    public Pillar(User user, DirectionGenerator directionGenerator) {
        this.user = user;
        this.directions = directionGenerator.createDirections();
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
}
