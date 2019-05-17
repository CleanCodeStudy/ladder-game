package view;

import domain.converter.OutputConverter;
import domain.converter.Point;
import domain.converter.Row;
import domain.ladder.Ladder;
import domain.ladder.LinkedType;
import domain.ladderCalculator.LadderIO;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static view.OutputLine.*;

public class OutputLadder {
    private LadderIO ladderIO;
    private Ladder ladder;

    private OutputLadder(LadderIO ladderIO, Ladder ladder) {
        this.ladder = ladder;
        this.ladderIO = ladderIO;
    }

    public static OutputLadder of(LadderIO ladderIO, Ladder ladder) {
        return new OutputLadder(ladderIO, ladder);
    }

    public void drawOutput() {
        List<Row> rows = OutputConverter.of(ladder).getRows();
        Collections.sort(rows);
        for (Row row : rows) {
            drawRow(row);
        }
    }

    public void drawUserNames() {
        StringBuilder sb = new StringBuilder();
        for (String user : ladderIO.getUsers()) {
            sb.append(user);
            sb.append(calculateBlank(user));
            sb.append(BLANK);
        }
        System.out.println(sb);
    }

    public void drawResults() {
        StringBuilder sb = new StringBuilder();
        for (String result : ladderIO.getResults()) {
            sb.append(result);
            sb.append(calculateBlank(result));
            sb.append(BLANK);
        }
        System.out.println(sb);
    }

    public void showLadderResult(String userName) {
        String result = userName.equals("all") ? showAllResult() : ladderIO.findResult(ladder, userName);
        System.out.println(result);
    }

    private String showAllResult() {
        StringBuilder sb = new StringBuilder();
        for (String user : ladderIO.getUsers()) {
            sb.append(user + ":" + ladderIO.findResult(ladder, user)+"\n");
        }
        return sb.toString();
    }

    private void drawRow(Row row) {
        List<Point> points = row.getPoints();
        Collections.sort(points);
        for (Point point : points) {
            System.out.print(drawPoint(point));
        }
        System.out.println();
    }

    private String drawPoint(Point point) {
        int repeat = ladderIO.getUserCharMaxNum();
        return point.isBlankPoint() ? DOWN + widthBlank(repeat) : Link(point);
    }

    private String calculateBlank(String result) {
        int width = ladderIO.getUserCharMaxNum() - result.length();
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, width)
                .forEach(each -> sb.append(BLANK));
        return sb.toString();
    }

    private String Link(Point point) {
        int repeat = ladderIO.getUserCharMaxNum();
        if (point.getBridge().getLinkPillarDirection() == LinkedType.RIGHT)
            return RIGHT + widthLine(repeat);
        return LEFT + widthBlank(repeat);
    }

}
