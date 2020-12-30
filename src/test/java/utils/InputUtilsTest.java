package utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InputUtilsTest {

    private final InputStream systemIn = System.in;

    @AfterEach
    public void clearSystemIn() {
        System.setIn(systemIn);
    }

    @Test
    void shouldReadLine() throws IOException {
        String inputData = "1 10 20 20 2 5";
        System.setIn(new ByteArrayInputStream(inputData.getBytes()));
        String result = InputUtils.readLine();
        assertEquals(inputData, result);
    }

    @Test
    void shouldThrowEmptyInputExceptionFromReadLine() {
        String inputData = " ";
        System.setIn(new ByteArrayInputStream(inputData.getBytes()));
        Exception exception = assertThrows(IllegalArgumentException.class, InputUtils::readLine);
        String expectedMessage = "The input is empty. Try again";
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void shouldReturnInputSplitBySpaces() throws IOException {
        String inputData = "1 2 10 7 5 3 6 6 13 0";
        System.setIn(new ByteArrayInputStream(inputData.getBytes()));
        String[] result = InputUtils.getInputSplitBySpaces();
        String[] expectedResult = {"1", "2", "10", "7", "5", "3", "6", "6", "13", "0"};
        assertArrayEquals(expectedResult, result);
    }

    @Test
    void shouldReturnInputNumber() throws IOException {
        String inputData = "3";
        System.setIn(new ByteArrayInputStream(inputData.getBytes()));
        Integer result = InputUtils.getInputNumber();
        Integer expectedResult = 3;
        assertEquals(expectedResult, result);
    }
}
