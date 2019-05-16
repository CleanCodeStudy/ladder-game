package dto;

public class GameStartOption {

    public static final String DELIMITER = ",";
    public static final int MINIMUM_LADDER_HEIGHT = 1;
    public static final int MINIMUM_PARTICIPANTS_COUNT = 2;


    private int ladderHeight;
    private String participants;

    public GameStartOption(String participants, int ladderHeight) {
        this.ladderHeight = ladderHeight;
        this.participants = participants;
        validate();
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

    private void validate(){
        if(ladderHeight < MINIMUM_LADDER_HEIGHT)
            throw new IllegalArgumentException("올바른 사다리 높이를 입력해주세요.");
        if(getLadderWidth() < MINIMUM_PARTICIPANTS_COUNT )
            throw new IllegalArgumentException(("참가자 수를 2명이상 입력해주세요."));
    }
}
