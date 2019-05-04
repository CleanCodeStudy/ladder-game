package com.cys.ladder.domain.generate;

import com.cys.ladder.LinkedStatus;
import com.cys.ladder.domain.Point;

import java.util.ArrayList;
import java.util.List;

public class LineMaker {
    List<Point> points = new ArrayList<>();

    public List<Point> generateLine(int playerNum) {
        addFirstPoint();
        generatePoint(playerNum);
        addLastPoint(playerNum);
        return new ArrayList<>(points);
    }

    private void addFirstPoint(){
        points.add(new Point(LinkedStatus.ofStart()));
    }

    private void generatePoint(int playerNum){
        Point previous = this.points.get(0);
        for (int i = 1; i < playerNum -1; i++) {
            Point current = new Point(previous.getColumn()+1,LinkedStatus.ofRandom(previous));
            points.add(current);
            previous = current;
        }
    }

    private void addLastPoint(int playerNum){
        Point lastPoint = new Point(playerNum,LinkedStatus.ofLast(points.get(playerNum-2)));
        points.add(lastPoint);
    }

}
