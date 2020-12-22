package utils;

public class NumberUtils {

    public static Integer parseInt(String value) throws NumberFormatException {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Input value must be a number. Try again.");
        }
    }
}
