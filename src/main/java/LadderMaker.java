import java.util.ArrayList;
import java.util.List;

public class LadderMaker {
    public  Ladder generateLadder(int height, int playerNum){
        List<Bridge> bridges = new ArrayList<>();
        for (int i = 1; i <=height; i++) {
            bridges.add(new Bridge(height,generatePoint(playerNum)));
        }
        return new Ladder(bridges);
    }

    private List<Point> generatePoint(int playerNum) {
        List<Point> points = new ArrayList<>();

        Point previous = null;
        for (int i = 1; i <= playerNum; i++) {
            Point current = generate(previous,playerNum);
            points.add(current);
            previous = current;
        }
        return points;
    }

    private Point generate(Point previous, int playerNum){
        if(previous == null){
            return new Point(1,LinkedStatus.ofStart());
        }

        if(previous.isLast(playerNum)){
            return new Point(playerNum,LinkedStatus.ofLast(previous));
        }

        return new Point(previous.getColumn()+1,LinkedStatus.ofRandom(previous));
    }

}
