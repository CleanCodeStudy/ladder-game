package data;

public class InputData {

    private int pillarCount;
    private int ladderHeight;

    public InputData(int pillarCount, int ladderHeight) {
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
