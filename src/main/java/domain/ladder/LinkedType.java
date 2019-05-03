package domain.ladder;

public enum LinkedType {
    RIGHT('├'),
    LEFT('┤');

    private char drawLink;

    LinkedType(char drawLink) {
        this.drawLink = drawLink;
    }

    public char getDrawLink() {
        return drawLink;
    }
}
