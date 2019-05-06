package view;

import dto.UserInputDto;

import java.io.InputStream;
import java.util.Scanner;

public class InputView {

    private Scanner scanner;

    public InputView(InputStream inputStream) {
        scanner = new Scanner(inputStream);
    }

    public UserInputDto getInputDto() {
        String names = getNames();
        String rewards = getRewards();
        int height = getHeight();
        return new UserInputDto(names, height, rewards);
    }

    private String getRewards() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String rewards = scanner.next();
        return rewards;
    }

    public String getNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return scanner.next();
    }

    public int getHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }

    public String getPrize() {
        System.out.println("결과를 보고 싶은 사람은?");
        return scanner.next();
    }
}
