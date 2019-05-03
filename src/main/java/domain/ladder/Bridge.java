package domain.ladder;

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

}
