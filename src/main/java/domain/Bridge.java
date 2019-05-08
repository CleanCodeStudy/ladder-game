package domain;

import java.util.List;

public class Bridge {
    private Integer height;
    private List<Point> points;

    public Bridge(int height,List<Point> points){
        this.height = height;
        this.points = points;
        validateBridge(points);
    }

    public List<Point> getPoints() {
        return points;
    }

    public Point nextPoint(int currentColumn){
        currentColumn --;
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

    public void validateBridge(List<Point> points){
        for(int i = 0 ; i < points.size() - 1 ; i++){
            Point current = points.get(i);
            Point next = points.get(i+1);

            if(current.getLinkedType() == next.getLinkedType()){
                throw new IllegalArgumentException();
            }
        }
    }

}
