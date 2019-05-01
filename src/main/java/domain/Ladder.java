package domain;

import java.util.List;

public class    Ladder {

    public static final int MINIMUM_PILLAR_NUM = 1;
    private List<Pillar> pillars;
    private Integer size;

    public List<Pillar> getPillars() {
        return pillars;
    }

    public Integer getCountOfPillars() {
        return pillars.size();
    }

    public Integer getSize() {
        return size;
    }

    public Pillar getPreviousPillar(int pillarNum) {
//        if(MINIMUM_PILLAR_NUM > pillarNum)
//            return ;
        return null;
    }


}
