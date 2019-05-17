package dto;

public class GameStartOption {

    public static final String DELIMITER = ",";
    public static final int MINIMUM_LADDER_HEIGHT = 1;
    public static final int MINIMUM_PARTICIPANTS_COUNT = 2;


    private int ladderHeight;
    private String participants;
    private String results;

    public GameStartOption(String participants, int ladderHeight, String results) {
        this.ladderHeight = ladderHeight;
        this.participants = participants;
        this.results = results;
        validate();
    }

    public static GameStartOption of(String participants, int ladderHeight, String results){
        return new GameStartOption(participants, ladderHeight, results);
    }

    private int getLadderWidth(String participants) {
        String[] parts = participants.split(DELIMITER);
        return parts.length;
    }

    public String getParticipants() {
        return participants;
    }

    public int getLadderWidth() {
        return getLadderWidth(participants);
    }

    public int getLadderHeight() {
        return ladderHeight;
    }

    public String getResults() {
        return results;
    }

    private void validate(){
        if(ladderHeight < MINIMUM_LADDER_HEIGHT)
            throw new IllegalArgumentException("올바른 사다리 높이를 입력해주세요.");
        if(getLadderWidth() < MINIMUM_PARTICIPANTS_COUNT )
            throw new IllegalArgumentException(("참가자 수를 2명이상 입력해주세요."));
        if(participants.split(DELIMITER).length != results.split(DELIMITER).length)
            throw new IllegalArgumentException(("결과와 참가자 수를 동일하게 입력해주세요."));
    }
}
