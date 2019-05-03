package data;

public class InputData {

    public static final String DELIMETER = ",";

    private int ladderWidth;
    private int ladderHeight;
    private String participants;

    public InputData(String participants, int ladderHeight) {
        this.ladderWidth = ladderWidth(participants);
        this.ladderHeight = ladderHeight;
        this.participants = participants;
    }

    private int ladderWidth(String participants) {
        String[] parts = participants.split(DELIMETER);
        return parts.length;
    }

    public String getParticipants() {
        return participants;
    }

    public int getLadderWidth() {
        return ladderWidth;
    }

    public int getLadderHeight() {
        return ladderHeight;
    }
}
