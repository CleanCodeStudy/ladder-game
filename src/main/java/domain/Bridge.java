package domain;


public class Bridge {
    private int location;
    private

    public Bridge(int location, int pillarIndex1) {
        this.location = location;
        this.pillarIndex1 = pillarIndex1;
        this.pillarIndex2 = pillarIndex1+1;
    }

    public int getLocation() {
        return location;
    }

//    // getPillarByIndex
//    public Pillar getPillarByIndex1() {
//        return pillarIndex1;
//    }

}
