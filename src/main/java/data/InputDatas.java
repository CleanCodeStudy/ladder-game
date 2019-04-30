package data;

public class InputDatas {

    private int pillarCount;
    private int ladderHeight;

    public InputDatas(int pillarCount, int ladderHeight) {
        this.pillarCount = pillarCount;
        this.ladderHeight = ladderHeight;
    }

    public int getPillarCount() {
        return pillarCount;
    }

    public int getLadderHeight() {
        return ladderHeight;
    }
}
