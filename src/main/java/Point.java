import java.util.Random;

public class Point {
    private Integer column;
    private LinkedType linkedType;

    public Point(int i){
        this.column = i;
    }

    private Point(Integer column,LinkedType linkedType) {
        this.column = column;
        this.linkedType = linkedType;
    }

    public LinkedType getLinkedType() {
        return linkedType;
    }

    public int getColumn() {
        return column;
    }

    public static Point createRightLinkedPoint(Point previous,Integer column){
        return new Point(column,LinkedType.RIGHT);
    }

    public static Point createLeftLinkedPoint(Integer column){
        return new Point(column,LinkedType.LEFT);
    }

    public static Point createNotLinkedPoint(Integer column){
        return new Point(column,LinkedType.NONE);
    }


}
