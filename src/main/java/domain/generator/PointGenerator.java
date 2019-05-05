package domain.generator;

import domain.Point;
import domain.LinkedType;

public class PointGenerator {

    public static Point generateFirstPoint(){
        return new Point(1,LinkedType.getRandomLinked());
    }

    public static Point generateNormalPoint(int column, Point previous){

        if(previous != null && previous.isRightLinked()){
            return new Point(column,LinkedType.LEFT);
        }

        return new Point(column,LinkedType.getRandomLinked());
    }

    public static Point generateLastPoint(int column, Point previous){
        if(previous != null && previous.isRightLinked()){
            return new Point(column,LinkedType.LEFT);
        }

        return previous.isRightLinked() ? new Point(column,LinkedType.LEFT) : new Point(column,LinkedType.NONE);
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
