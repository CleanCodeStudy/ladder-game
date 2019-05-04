package domain;

import domain.Point;
import util.LinkedType;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private Integer height;
    private List<Point> points;

    public Bridge(int height,List<Point> points){
        this.height = height;
        this.points = points;
    }

    public Integer getHeight() {
        return height;
    }

    public List<Point> getPoints() {
        return points;
    }

    public static Bridge createBridge(int height, int playerNumber){
        List<Point> points = new ArrayList<>();

        Point firstPoint = Point.createPoint(1,null);
        points.add(firstPoint);

        for (int i = 1; i < playerNumber-1; i++){
            Point previous = points.get(i-1);
            Point current = Point.createPoint(i+1,previous);
            points.add(current);
        }

        Point lastPoint = Point.createNotLinkedPoint(playerNumber);

        if(points.get(playerNumber-2).getLinkedType() == LinkedType.RIGHT){
            lastPoint = Point.createLeftLinkedPoint(playerNumber);
        }
        points.add(lastPoint);

        return new Bridge(height,points);
    }

//    public static Bridge createFixedBridge(int height, int playerNumber) {
//        List<Point> points = new ArrayList<>();
//
//    }

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
}
