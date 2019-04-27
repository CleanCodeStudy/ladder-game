public class Bridge {
    private Integer location;
    private LinkedType linkPillarDirection;

    public Bridge(Integer location, LinkedType linkPillarDirection) {
        this.location = location;
        this.linkPillarDirection = linkPillarDirection;
    }


    public Integer getLocation() {
        return location;
    }

    public LinkedType getLinkPillarDirection() {
        return linkPillarDirection;
    }

//    public Point nextPoint(int currentColumn) {
//        Point point = points.get(currentColumn);
//        if (point.getLinkedType() == LinkedType.RIGHT) {
//            Point nextPoint = points.get(currentColumn + 1);
//            return nextPoint;
//        }
//        if (point.getLinkedType() == LinkedType.LEFT) {
//            Point nextPoint = points.get(currentColumn-1);
//            return nextPoint;
//        }
//
//        return point;
//    }
}
