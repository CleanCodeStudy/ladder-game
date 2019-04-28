import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private Integer height;
    private List<Point> points;

    public Bridge(Integer height, List<Point> points) {
        this.height = height;
        this.points = points;
    }

    public List<Point> create(int playerNumber){
        List<Point> points = new ArrayList<>();
        Point previous = new Point(0);
        for (int i = 0; i < playerNumber; i++) {
            Point current = Point.create(previous);
        }
    }

    public void link(){
        Point pre = points.get(0);
        if(pr)
    }



    public Point nextPoint(int currentColumn) {
        Point point = points.get(currentColumn);
        if (point.getLinkedType() == LinkedType.RIGHT) {
            Point nextPoint = points.get(currentColumn + 1);
            return nextPoint;
        }
        if (point.getLinkedType() == LinkedType.LEFT) {
            Point nextPoint = points.get(currentColumn - 1);
            return nextPoint;
        }

        return point;
    }
}
