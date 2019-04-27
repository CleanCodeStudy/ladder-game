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
        int height = getHeight();
        return new UserInputDto(names, height);
    }

    public String getNames() {
        return scanner.next();
    }

    public int getHeight() {
        return scanner.nextInt();
    }
}
