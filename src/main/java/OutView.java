import java.util.List;

public class OutView {

    public static void draw(LadderGame game){
         Ladder ladder = game.getLadder();
         drawBridges(ladder.getBridges());
    }

    private static void drawBridges(List<Bridge> bridges){
        for (Bridge bridge: bridges) {
            drawRow(bridge.getPoints());
        }
    }

    private static void drawRow(List<Point> points){
        for(Point point: points){
            System.out.print("|");
            System.out.print(drawLine(point));
        }
        System.out.println();
    }

    private static String drawLine(Point point){
        if(point.isRightLinked()){
            return "-----";
        }
        return  "     ";
    }



}
