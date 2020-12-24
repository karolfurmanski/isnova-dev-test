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

    public static String[] getInputArray() throws IOException, IllegalArgumentException {
        String input = readLine();
        return input.split(" ");
    }

    public static Integer getInputNumber() throws IOException, IllegalArgumentException {
        String input = readLine();
        return NumberUtils.parseInt(input);
    }

    public static int[][] getInputMatrix() throws IOException, IllegalArgumentException {
        String input = InputUtils.readLine();
        int numberOfLines = NumberUtils.parseInt(input);
        int[][] matrix = new int[numberOfLines][numberOfLines];

        for (int i = 0; i < numberOfLines; i++) {
            String[] pair = InputUtils.getInputArray();
            int x = NumberUtils.parseInt(pair[0]);
            int y = NumberUtils.parseInt(pair[1]);
            matrix[x][y] = 1;
            matrix[y][x] = 1;
        }

        return matrix;
    }
}
