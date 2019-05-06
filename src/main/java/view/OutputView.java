package view;

import domain.direction.Direction;
import domain.ladder.Ladder;
import domain.ladder.ladderResult.LadderResult;

import java.util.List;
import java.util.stream.IntStream;

public class OutputView {

    private static final String DOWN = "│";
    private static final String LEFT = "┤";
    private static final String RIGHT = "├";
    private static final String HORIZON = "─";
    private static final String BLANK = " ";
    private static final String LINE_BREAK = "\n";

    private Ladder ladder;
    private LadderResult ladderResult;

    public OutputView(Ladder ladder, LadderResult ladderResult) {
        this.ladder = ladder;
        this.ladderResult = ladderResult;
    }

    public void showLadder() {
        showNames();
        showPillar();
        showRewards();
    }

    public void showNames() {
        int max = getMax(ladder.getNames());

        StringBuilder sb = new StringBuilder();
        for (String name : ladder.getNames()) {
            sb.append(name);
            sb.append(drawNameBlank(name, max));
        }
        System.out.println(sb.toString());
    }

    private void showPillar() {
        StringBuilder sb = new StringBuilder();

        for (int y = 0; y < ladder.getHeight(); y++) {
            sb.append(drawPillar(y));
            sb.append(LINE_BREAK);
        }
        System.out.println(sb.toString());
    }

    private void showRewards() {
        int max = getMax(ladder.getNames());
        StringBuilder sb = new StringBuilder();
        for (String reward : ladder.getReward()) {
            sb.append(reward);
            sb.append(drawNameBlank(reward, max));
        }
        System.out.println(sb.toString() + "\n");
    }

    private String drawNameBlank(String name, int max) {
        StringBuilder sb = new StringBuilder();
        int width = max - name.length() + 1;

        sb.append(addWidth(width, BLANK));

        return sb.toString();
    }

    private String drawPillar(int y) {
        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < ladder.getNames().size(); x++) {
            sb.append(getStick(ladder.getDirection(x, y)));
        }
        return sb.toString();
    }

    private String getStick(Direction direction) {
        StringBuilder sb = new StringBuilder();
        int width = getMax(ladder.getNames());
        sb.append(findStick(direction));
        if (!direction.isRight()) {
            sb.append(addWidth(width, BLANK));
            return sb.toString();
        }
        sb.append(addWidth(width, HORIZON));
        return sb.toString();
    }

    private String findStick(Direction direction) {
        if (direction.isRight()) {
            return RIGHT;
        }
        if (direction == Direction.LEFT) {
            return LEFT;
        }
        if (direction == Direction.DOWN) {
            return DOWN;
        }
        throw new RuntimeException();
    }

    private String addWidth(int width, String add) {
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, width)
                .forEach(each -> sb.append(add));
        return sb.toString();
    }


    public int getMax(List<String> names) {
        return names.stream()
                .mapToInt(name -> name.length())
                .max()
                .getAsInt();
    }

    public void showResult(String name) {
        System.out.println("실행 결과");
        if (name.equals("all")) {
            showAll();
            return;
        }
        String reward = ladderResult.findRewardByName(name);
        System.out.println(reward);
    }

    private void showAll() {
        ladderResult.getAllRewards().stream()
                .forEach(pair -> System.out.println(String.format("%s : %s", pair.getUserName(), pair.getReward())));
    }
}
