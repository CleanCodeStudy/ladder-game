package domain;

import java.util.List;

public class Pillar {

    private int id;
    private int height;
    private List<Direction> directions;

    public Pillar(int id, int height) {
        this.id = id;
        this.height = height;
    }

    public int getId() {
        return id;
    }

    public int getHeight() {
        return height;
    }


}
