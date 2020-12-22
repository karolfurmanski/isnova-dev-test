package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputUtils {

    public static String readLine() throws IOException, IllegalArgumentException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input;

        try {
            input = bufferedReader.readLine();
        } catch (IOException exception) {
            throw new IOException("The input is invalid. Try again.");
        }

        if (StringUtils.isEmpty(input))
            throw new IllegalArgumentException("The input is empty. Try again");

        return input;
    }
}
