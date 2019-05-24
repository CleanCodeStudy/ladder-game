package com.cys.ladder.view;

import com.cys.ladder.domain.GameResult;
import com.cys.ladder.domain.endpoint.User;
import com.cys.ladder.domain.ladder.Bridge;
import com.cys.ladder.domain.ladder.Ladder;
import com.cys.ladder.domain.ladder.Point;
import com.cys.ladder.domain.endpoint.Prize;
import com.cys.ladder.domain.endpoint.PrizeCollection;
import com.cys.ladder.domain.endpoint.UserCollection;

import java.util.List;

public class OutView {

    public static void draw(Ladder ladder, PrizeCollection prizes, UserCollection users){
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
        return point.isRightLinked() ?  "-----" : "     ";
    }

    private static void drawPrize(List<Prize> prizes){
        for (Prize prize: prizes) {
            System.out.print(prize.getPrize());
            System.out.print("     ");
        }
    }

    public static void drawResult(GameResult gameResult, String name) {
        if(name.equals("all")){
            gameResult.getResults()
                    .forEach((user, prize) -> String.format("%s : %s",user.getName(),prize.getPrize()));
            return;
        }

        System.out.println(gameResult.findByResult(name));
    }
}
