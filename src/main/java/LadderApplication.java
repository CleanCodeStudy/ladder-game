public class LadderApplication {
    public static void main(String[] args) {
        LadderGame ladderGame = new LadderGame(inputUap(),new LadderMaker());
        OutView.draw();


    }

    private static UAP inputUap(){
        return InputView.inputUAP().toEntity();
    }
}
