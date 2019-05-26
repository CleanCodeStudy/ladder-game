package view;

public class OutputLine {
    public static final String DOWN = "│";
    public static final String HORIZON = "─";
    public static final String RIGHT = "├";
    public static final String LEFT = "┤";
    public static final String BLANK = " ";

    public static String widthLine(int repeat) {
        return new String(new char[repeat]).replace("\0", HORIZON);
    }

    public static String widthBlank(int repeat) {
        return new String(new char[repeat]).replace("\0", BLANK);
    }
}
