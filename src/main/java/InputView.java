import java.util.Scanner;

public class InputView {

    public static UAPDto inputUAP(){
        return new UAPDto(getScanner().nextLine(),getScanner().nextLine());
    }

    private static Scanner getScanner(){
        return new Scanner(System.in);
    }
}
