package domain;

import util.LinkedType;

import java.util.Random;

public class Point {
    private Integer column;
    private LinkedType linkedType;

    public Point(int i){
        this.column = i;
    }

    private Point(Integer column, LinkedType linkedType) {
        this.column = column;
        this.linkedType = linkedType;
    }

    public LinkedType getLinkedType() {
        return linkedType;
    }

    public int getColumn() {
        return column;
    }

    public static Point createPoint(Integer column,Point previous){

        if(previous != null && previous.getLinkedType() == LinkedType.RIGHT){
            return createLeftLinkedPoint(column);
        }

        if(new Random().nextBoolean()){
            return createRightLinkedPoint(column);
        }

        return createNotLinkedPoint(column);
    }

    public static Point createRightLinkedPoint(Integer column){
        return new Point(column, LinkedType.RIGHT);
    }

    public static Point createLeftLinkedPoint(Integer column){
        return new Point(column, LinkedType.LEFT);
    }

    public static Point createNotLinkedPoint(Integer column){
        return new Point(column, LinkedType.NONE);
    }
}
