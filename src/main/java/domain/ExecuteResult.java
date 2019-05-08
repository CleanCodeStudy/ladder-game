package domain;

public class ExecuteResult {
    private String result;
    private int column;

    public ExecuteResult(String result, int column) {
        this.result = result;
        this.column = column;
    }

    public String getResult() {
        return result;
    }

    public int getColumn() {
        return column;
    }
}
