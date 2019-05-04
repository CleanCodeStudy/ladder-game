package view;

import dto.GameInformationDto;

import java.io.InputStream;
import java.util.Scanner;

public class InputView {
    public static Scanner scanner;

    public InputView(InputStream inputStream) {
        scanner = new Scanner(inputStream);
    }
    public GameInformationDto getGameInformationDto(){
        String players = inputPlayerNames();
        String executeResult= inputExecuteResult();
        int ladderHeight = inputLadderHeight();
        return new GameInformationDto(players,executeResult,ladderHeight);
    }

    public String inputPlayerNames() {
        System.out.println("참여할 사람을 입력해주세요. (이름은 쉼표(,)로 구분하세요)");

        String players = scanner.nextLine();

        return players.replace(" ","");
    }

    public String inputExecuteResult() {
        System.out.println("실행 결과를 입력해주세요. (결과는 쉼표(,)로 구분하세요)");

        String playResult = scanner.nextLine();

        return playResult.replace(" ", "");
    }

    public int inputLadderHeight() {
        System.out.println("최대 사다리높이를 입력해주세요.");
        int ladderHeight = Integer.parseInt(scanner.nextLine());
        return ladderHeight;
    }

    public String inputTargetPlayer(){
        System.out.println("결과를 보고싶은 사람의 이름을 입력해주세요.");
        System.out.println("all을 입력할 경우 전체 결과를 보여주고 프로그램을 종료합니다.");

        return scanner.nextLine();
    }
}
