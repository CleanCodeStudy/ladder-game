package domain.ladder;

import domain.maker.LadderMaker;
import dto.GameStartOption;

import java.util.List;
import java.util.Optional;

public class Ladder {

    private List<Pillar> pillars;
    private Integer width;
    private Integer height;

    private Ladder(GameStartOption gameStartOption) {
        this.width = gameStartOption.getLadderWidth();
        this.height = gameStartOption.getLadderHeight();
        this.pillars = LadderMaker.of().createLadder(gameStartOption);
    }

    public static Ladder of(GameStartOption gameStartOption) {
        return new Ladder(gameStartOption);
    }

    public Pillar getPillarByNum(Integer pillarNum) {
        return pillars.stream()
                .filter(p -> p.getPillarNum() == pillarNum)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new); // optional orElse에 null 던지지 말기 throw Exception
    }

    public List<Pillar> getPillars() {
        return pillars;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }

    public Pillar getNextPillar(Pillar nowPillar, Integer nowLocation) {
        Optional<Bridge> linkBridge = nowPillar.getLevelBridges(nowLocation);
        if (!linkBridge.isPresent())
            return nowPillar;
        return linkBridge.get().getLinkPillarDirection() == LinkedType.RIGHT ?
                getPillarByNum(nowPillar.getPillarNum() + 1) :
                getPillarByNum(nowPillar.getPillarNum() - 1);
    }

}
