import java.util.List;

public class Ladder {
    private List<Bridge> bridges;

    public Ladder(List<Bridge> bridges) {
        this.bridges = bridges;
    }

    public List<Bridge> getBridges() {
        return bridges;
    }
}
