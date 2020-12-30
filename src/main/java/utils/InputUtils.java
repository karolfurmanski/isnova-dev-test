package utils;

import models.Pair;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.SortedSet;
import java.util.TreeSet;

public class InputUtils {

    public static String readLine() throws IOException, IllegalArgumentException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input;

        try {
            input = bufferedReader.readLine();
        } catch (IOException exception) {
            throw new IOException("The input is invalid. Try again.");
        }

        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException("The input is empty. Try again");
        }

        return input;
    }

    public static String[] getInputSplitBySpaces() throws IOException, IllegalArgumentException {
        String input = readLine();
        return input.split(" ");
    }

    public static Integer getInputNumber() throws IOException, IllegalArgumentException {
        String input = readLine();
        return Integer.parseInt(input);
    }

    public static SortedSet<Pair> getInputEdges() throws IOException, IllegalArgumentException {
        int numberOfLines = getInputNumber();
        SortedSet<Pair> pairs = new TreeSet<>();

        for (int i = 0; i < numberOfLines; i++) {
            String[] pair = InputUtils.getInputSplitBySpaces();
            int x = Integer.parseInt(pair[0]);
            int y = Integer.parseInt(pair[1]);
            pairs.add(new Pair(Math.min(x, y), Math.max(x, y)));
        }

        return pairs;
    }
}
