package domain.generator;

import domain.Bridge;
import domain.Point;

import java.util.ArrayList;
import java.util.List;

public class BridgeGenerator {
    private List<Point> points = new ArrayList<>();

    public Bridge generate(int height, int playerNum){
        points.add(PointGenerator.generateFirstPoint());

        for(int  i = 1 ; i < playerNum - 1; i++){
            Point previous = points.get(i-1);
            points.add(PointGenerator.generateNormalPoint(i+1,previous));
        }

        points.add(PointGenerator.generateLastPoint(playerNum,points.get(playerNum-2)));

        return alloc(height,points);
    }

    private Bridge alloc(int height, List<Point> points){
        List<Point> pointsOfBridge = new ArrayList<>(points);
        points.clear();
        return new Bridge(height,pointsOfBridge);
    }

}
