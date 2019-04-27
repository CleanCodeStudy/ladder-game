package view;

import domain.Ladder;
import domain.direction.Direction;

import java.util.List;

public class OutputView {

    private static final String DOWN = "ㅣ";
    private static final String LEFT = "ㅓ";
    private static final String RIGHT = "ㅏ";
    private static final String HORIZON = "ㅡ";

    public void showLadder(Ladder ladder) {
        showNames(ladder);
        showPillar(ladder);
    }

    private void showPillar(Ladder ladder) {
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < ladder.getHeight(); y++) {
            for (int x = 0; x < ladder.getNames().size(); x++) {
                sb.append(getDirect(ladder.getPillarDirection(x, y)));
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private String getDirect(Direction direction) {
        StringBuilder sb = new StringBuilder();
        if (direction == Direction.LEFT) {
            sb.append(LEFT);
        }
        if (direction == Direction.RIGHT) {
            sb.append(RIGHT);
        }
        if (direction == Direction.DOWN) {
            sb.append(DOWN);
        }
        return sb.toString();
    }

    public void showNames(Ladder ladder) {
        List<String> names = ladder.getNames();
        int width = getWidth(names);
        String blank = makeWitdh(width);
        StringBuilder sb = new StringBuilder();
        for (String name : names) {
            sb.append(name).append(blank);
        }
        System.out.println(sb.toString());
    }

    private String makeWitdh(int width) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < width; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    public int getWidth(List<String> names) {

        int min = names.stream()
                .mapToInt(name -> name.length())
                .min()
                .getAsInt();

        return names.stream()
                .mapToInt(name -> name.length())
                .max()
                .getAsInt() - min;
    }
}
