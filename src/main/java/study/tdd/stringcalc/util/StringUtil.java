package study.tdd.stringcalc.util;

public class StringUtil {
    public static String[] split(String input) {
        // 공백으로 split
        return input.split(" ");
    }

    public static int toInt(String input) {
        return Integer.parseInt(input);
    }
}
