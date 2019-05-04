package com.cys.ladder.domain.generate;

import com.cys.ladder.domain.LinkedStatus;
import com.cys.ladder.domain.ladder.Point;

import java.util.ArrayList;
import java.util.List;

public class LineMaker {
    private List<Point> points = new ArrayList<>();

    List<Point> generateLine(int playerNum) {
        addFirstPoint();
        generatePoint(playerNum);
        addLastPoint(playerNum);
        return alloc(points);
    }

    private void addFirstPoint(){
        points.add(new Point(LinkedStatus.ofRandom()));
    }

    private void generatePoint(int playerNum){
        Point previous = this.points.get(0);
        for (int i = 1; i < playerNum -1; i++) {
            Point current = new Point(previous.getColumn()+1,LinkedStatus.ofPrevious(previous));
            points.add(current);
            previous = current;
        }
    }

    private void addLastPoint(int playerNum){
        Point lastPoint = new Point(playerNum,LinkedStatus.createLastLink(points.get(playerNum-2)));
        points.add(lastPoint);
    }

    private List<Point> alloc(List<Point> points){
        List<Point> line = new ArrayList<>(points);
        points.clear();
        return line;
    }
}
