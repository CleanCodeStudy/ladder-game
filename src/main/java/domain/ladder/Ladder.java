package domain.ladder;

import dto.GameStartOption;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private List<Pillar> pillars;
    private Integer width;
    private Integer height;

    public Ladder(GameStartOption gameStartOption) {
        this.width = gameStartOption.getLadderWidth();
        this.height = gameStartOption.getLadderHeight();
        this.pillars = createLadder(gameStartOption);
    }

    private List<Pillar> createLadder(GameStartOption gameStartOption) {
        List<Pillar> pillars = new ArrayList<>();
        Pillar previous = new Pillar(gameStartOption, null); //팩토리 메소드 패턴 or construction 1개
        pillars.add(previous);
        for (int i = 1; i < width; i++) {
            Pillar now = new Pillar(gameStartOption, previous);
            pillars.add(now);
            previous = now;
        }
        return pillars;
    }

    public Pillar getPillarByNum(Integer pillarNum) {
        return pillars.stream()
                .filter(p -> p.getPillarNum() == pillarNum)
                .findFirst()
                .orElseThrow(IllegalArgumentException :: new); // optional orElse에 null 던지지 말기 throw Exception
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

}
