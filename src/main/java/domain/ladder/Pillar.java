package domain.ladder;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Pillar {

    private List<Bridge> bridges;
    private Integer pillarNum;

    private Pillar(List<Bridge> bridges, Integer pillarNum) {
        this.bridges = bridges;
        this.pillarNum = pillarNum;
    }

    public static Pillar of(List<Bridge> bridges, Integer pillarNum) {
        return new Pillar(bridges, pillarNum);
    }

    public Integer getPillarNum() {
        return pillarNum;
    }

    public List<Bridge> getBridges() {
        return bridges;
    }

    public Optional<Bridge> getLevelBridges(Integer level) {
        return bridges.stream()
                .filter(bridge -> bridge.getLocation().equals(level))
                .findFirst();
    }

    public List<Integer> getBridgesLocations() {
        return bridges.stream()
                .map(b -> b.getLocation())
                .collect(Collectors.toList());
    }

    public List<Integer> getBridgesDirectionLocation(LinkedType linkedType) {
        return bridges.stream()
                .filter(b -> b.getLinkPillarDirection() == linkedType)
                .map(bridge -> bridge.getLocation())
                .collect(Collectors.toList());
    }
}