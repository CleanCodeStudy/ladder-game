import java.util.List;

public class
Bridge {
    private Integer height;
    private List<Point> points;

    public Bridge(Integer height, List<Point> points) {
        this.height = height;
        this.points = points;
    }

    public Point nextPoint(int currentColumn) {
        Point point = points.get(currentColumn);
        if (point.getLinkedType() == LinkedType.RIGHT) {
            Point nextPoint = points.get(currentColumn + 1);
            return nextPoint;
        }
        if (point.getLinkedType() == LinkedType.LEFT) {
            Point nextPoint = points.get(currentColumn-1);
            return nextPoint;
        }

        return point;
    }
}
