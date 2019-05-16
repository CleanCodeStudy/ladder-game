package domain.ladder;

public class Bridge {
    private Integer location;
    private LinkedType linkPillarDirection;

    private Bridge(Integer location, LinkedType linkPillarDirection) {
        this.location = location;
        this.linkPillarDirection = linkPillarDirection;
    }

    public Integer getLocation() {
        return location;
    }

    public LinkedType getLinkPillarDirection() {
        return linkPillarDirection;
    }

    public static Bridge createOneRightBridge(Integer location) {
        return (new Bridge(location, LinkedType.RIGHT));
    }

    public static Bridge createOneLeftBridge(Integer location) {
        return (new Bridge(location, LinkedType.LEFT));
    }

}
