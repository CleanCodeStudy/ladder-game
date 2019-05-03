public class Point {
    private Integer column;
    private LinkedStatus linkedStatus;

    public Point(Integer column) {
        this.column = column;
    }

    public Point(Integer column, LinkedStatus linkedStatus) {
        this.column = column;
        this.linkedStatus = linkedStatus;
    }

    public boolean isRightLinked(){
        return linkedStatus == LinkedStatus.RIGHT;
    }

    public boolean isLinked() {
        return linkedStatus == LinkedStatus.RIGHT || linkedStatus == LinkedStatus.LEFT;
    }

    public int getColumn() {
        return column;
    }

    public boolean isLast(int playerNum) {
        return column + 1 == playerNum;
    }
}
