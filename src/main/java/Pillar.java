import java.util.List;

public class Pillar {
    private List<Bridge> bridges;
    private Integer pillarNum;

    public Pillar(Integer pillarNum){

    }

    private void createOneRightBridege(Integer location){
        Bridge bridge = new Bridge(location, LinkedType.RIGHT);
    }

    private void createOneLeftBridege(Integer location){
        Bridge bridge = new Bridge(location, LinkedType.LEFT);
    }
}