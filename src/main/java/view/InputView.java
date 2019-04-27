package view;

import java.io.InputStream;
import java.util.Scanner;

public class InputView {

    private Scanner scanner;

    public InputView(InputStream inputStream) {
        scanner = new Scanner(inputStream);
    }

    public String getNames() {
        return scanner.next();
    }

    public int getHeight() {
        return scanner.nextInt();
    }
}
