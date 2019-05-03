public class LadderApplication {
    public static void main(String[] args) {
        Endpoint endpoint = InputView.inputEndPoint();
        LadderOption option = new LadderOption(InputView.inputHeight(), endpoint.getPlayerNum());

        OutView.draw(LadderMaker.generateLadder(option),endpoint.toEntityPrizes(),endpoint.toEntityUsers());
    }



}
