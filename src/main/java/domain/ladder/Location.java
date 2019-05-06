package domain.ladder;

public class Location {

    private int x;
    private int y;

    public Location(int x, int y) {
        validate(x, y);
        this.x = x;
        this.y = y;
    }

    private void validate(int x, int y) {
        if (x < 0) {
            throw new IllegalArgumentException("x error");
        }
        if (y < 0) {
            throw new IllegalArgumentException("y error");
        }
    }

    public Location(Location location) {
        this.x = location.getX() + 1;
        this.y = location.getY();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isEqual(int x, int y) {
        return this.x == x && this.y == y;
    }
}
