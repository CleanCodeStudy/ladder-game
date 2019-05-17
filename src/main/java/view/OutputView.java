package view;

import domain.converter.OutputConverter;
import domain.converter.Point;
import domain.converter.Row;
import domain.ladder.Ladder;
import domain.ladder.LinkedType;
import domain.user.ParticipantUsers;
import domain.user.User;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static view.OutputLine.*;

public class OutputView {
    private ParticipantUsers participantUsers;
    private Ladder ladder;

    private OutputView(ParticipantUsers participantUsers, Ladder ladder) {
        this.ladder = ladder;
        this.participantUsers = participantUsers;
    }

    public static OutputView of(ParticipantUsers participantUsers, Ladder ladder) {
        return new OutputView(participantUsers, ladder);
    }

    public void drawOutput() {
        List<Row> rows = OutputConverter.of(ladder).getRows();
        Collections.sort(rows);
        for (Row row : rows) {
            drawRow(row);
        }
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
        int repeat = participantUsers.getUserCharMaxNum();
        return point.isBlankPoint() ? DOWN + widthBlank(repeat) : Link(point);
    }

    public void drawUserNames() {
        StringBuilder sb = new StringBuilder();
        for (User user : participantUsers.getUsers()) {
            sb.append(user.getName());
            sb.append(nameBlank(user));
            sb.append(BLANK);
        }
        System.out.println(sb);
    }

    private String nameBlank(User user) {
        int width = participantUsers.getUserCharMaxNum() - user.getName().length();
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, width)
                .forEach(each -> sb.append(BLANK));
        return sb.toString();
    }

    private String Link(Point point) {
        int repeat = participantUsers.getUserCharMaxNum();
        if (point.getBridge().getLinkPillarDirection() == LinkedType.RIGHT)
            return RIGHT + widthLine(repeat);
        return LEFT + widthBlank(repeat);
    }

}
