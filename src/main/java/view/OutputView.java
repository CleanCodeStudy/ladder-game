package view;

import domain.ladder.Ladder;
import domain.ladder.LinkedType;
import domain.ladder.Pillar;
import domain.user.ParticipantUsers;
import domain.user.User;

import java.util.Arrays;
import java.util.stream.IntStream;

public class OutputView {

//    가로로 찍을 수 있게 변환해서
//    dto로 bridge와 그 높이 들고있는 dto만들어서 가로로 변환해서
//    찍기 편한 형태로 변환하기
//    flatMap으로 쭉 적으면서
//    bridge 1개랑 level 들고있으면 (Converter class 만들기)

    /*
        높이만큼 돌고 높이 1일 때
     */

    public static final int PILLAR_WIDTH_SURPLUS = 1;
    private static final char DOWN = '│';
    private static final char HORIZON = '─';
    private static final char RIGHT = '├';
    private static final char LEFT = '┤';
    private static final char BLANK = ' ';

    private char[][] ladderDrawing;
    private int basicNum;
    private int ladderHeight;
    private ParticipantUsers participantUsers;

    private OutputView(ParticipantUsers participantUsers, Ladder ladder) {
        this.basicNum = calculateBasicsNum(participantUsers);
        this.ladderHeight = ladder.getHeight();
        this.ladderDrawing = drawAllLadder(ladder);
        this.participantUsers = participantUsers;
    }

    public static OutputView of(ParticipantUsers participantUsers, Ladder ladder){
        return new OutputView(participantUsers, ladder);
    }

    public void printLadder() {
        System.out.println(makeUserNames());
        System.out.println(makeStringLadder());
    }

    private String makeStringLadder() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ladderHeight; i++) {
            sb.append(new String(ladderDrawing[i]) + "\n");
        }
        return sb.toString();
    }

    private String makeUserNames() {
        StringBuilder sb = new StringBuilder();
        for (User user : participantUsers.getUsers()) {
            sb.append(user.getName());
            sb.append(nameBlank(user));
        }
        return sb.toString();
    }


    private String nameBlank(User user) {
        int width = basicNum - user.getName().length() + PILLAR_WIDTH_SURPLUS;
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, width)
                .forEach(each -> sb.append(BLANK));
        return sb.toString();
    }

    private char[][] drawAllLadder(Ladder ladder) {
        char[][] charLadder = drawLadderInit(ladder);
        for (int i = 0; i < ladder.getWidth(); i++) {
            drawPillar(charLadder, ladder.getPillarByNum(i));
        }
        return charLadder;
    }

    private char[][] drawLadderInit(Ladder ladder) {
        char[][] charLadder = new char[ladderHeight][calculateDrawingWidth(ladder)];
        for (int i = 0; i < ladderHeight; i++) {
            Arrays.fill(charLadder[i], BLANK);
        }
        return charLadder;
    }

    private void drawPillar(char[][] charLadder, Pillar pillar) {
        for (int i = 0; i < ladderHeight; i++) {
            int mainPillarIdx = pillar.getPillarNum() * (basicNum + PILLAR_WIDTH_SURPLUS);
            charLadder[i][mainPillarIdx] = DOWN;
        }
        for (Integer location : pillar.getBridgesDirectionLocation(LinkedType.RIGHT)) {
            drawPillarWithRIGHTLink(charLadder[location], pillar.getPillarNum());
        }
        for (Integer location : pillar.getBridgesDirectionLocation(LinkedType.LEFT)) {
            charLadder[location][pillar.getPillarNum() * (basicNum + PILLAR_WIDTH_SURPLUS)] = LEFT;
        }
    }

    private void drawPillarWithRIGHTLink(char[] ladderRow, Integer pillarNum) {
        int mainPillarIdx = pillarNum * (basicNum + PILLAR_WIDTH_SURPLUS);
        ladderRow[mainPillarIdx] = RIGHT;
        for (int i = mainPillarIdx + PILLAR_WIDTH_SURPLUS; i <= mainPillarIdx + basicNum; i++) {
            ladderRow[i] = HORIZON;
        }
    }

    private int calculateDrawingWidth(Ladder ladder) {
        return ladder.getWidth() * basicNum;
    }

    private int calculateBasicsNum(ParticipantUsers participantUsers) {
        return participantUsers.getUserCharMaxNum();
    }

}
