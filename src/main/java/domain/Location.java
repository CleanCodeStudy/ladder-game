package domain;

public class Location {

    private int x;
    private int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
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
