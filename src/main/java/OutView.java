import java.util.List;

public class OutView {

    public static void draw(Ladder ladder,PrizeCollection prizes, UserCollection users){
         drawUser(users.getUsers());
         drawBridges(ladder.getBridges());
         drawPrize(prizes.getPrizes());
    }

    private static void drawUser(List<User> users){
        for (User user : users) {
            System.out.print(user.getName());
            System.out.print("     ");
        }

        System.out.println();
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

    private static void drawPrize(List<Prize> prizes){
        for (Prize prize: prizes) {
            System.out.print(prize.getPrize());
            System.out.print("     ");
        }
    }

}
