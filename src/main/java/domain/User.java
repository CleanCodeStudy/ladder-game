package domain;

public class User {
    private String name;
    private int startColumn;

    public User(String name, int startColumn) {
        this.name = name;
        this.startColumn = startColumn;
    }

    public String getName() {
        return name;
    }

    public int getStartColumn() {
        return startColumn;
    }
}
