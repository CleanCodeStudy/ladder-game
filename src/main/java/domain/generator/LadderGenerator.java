package domain.generator;

import domain.Bridge;
import domain.Ladder;

import java.util.ArrayList;
import java.util.List;

public class LadderGenerator {
    public static Ladder generate(int ladderHeight, int playerNumber){

        List<Bridge> bridges = new ArrayList<>();

        for(int i = 0 ; i < ladderHeight ; i++){
            BridgeGenerator bridgeGenerator = new BridgeGenerator();
            Bridge bridge = bridgeGenerator.generate(ladderHeight,playerNumber);
            bridges.add(bridge);
        }

        return new Ladder(ladderHeight,playerNumber,bridges);
    }
}
