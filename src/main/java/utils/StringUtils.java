package utils;

import java.util.Objects;

public class StringUtils {

    public static boolean isEmpty(String value) {
        return Objects.isNull(value) || value.isEmpty() || isWhiteSpace(value);
    }

    private static boolean isWhiteSpace(String value) {
        return value.chars().allMatch(Character::isWhitespace);
    }
}
