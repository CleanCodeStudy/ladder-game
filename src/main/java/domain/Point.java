package domain;

public class Point {
    private Integer column;
    private LinkedType linkedType;

    public Point(Integer column, LinkedType linkedType) {
        this.column = column;
        this.linkedType = linkedType;
    }

    public int getColumn() {
        return column;
    }

    public LinkedType getLinkedType() {
        return linkedType;
    }

    public boolean isRightLinked(){
        return this.linkedType == LinkedType.RIGHT;
    }

    public boolean isLeftLinked(){
        return this.linkedType == LinkedType.LEFT;
    }
}
