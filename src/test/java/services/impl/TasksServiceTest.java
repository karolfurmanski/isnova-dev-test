package services.impl;

import models.Pair;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import services.ITasksService;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.SortedSet;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TasksServiceTest {

    private static ITasksService tasksService;

    @BeforeAll
    public static void setUp() {
        tasksService = new TasksService();
    }

    @ParameterizedTest
    @MethodSource("argumentsForDistinctValues")
    void shouldReturnDistinctValues(String input, int distinct, int min, int max) {
        String[] array = input.split(" ");
        SortedSet<Integer> distinctValues = tasksService.getDistinctValues(array);
        assertEquals(distinct, distinctValues.size());
        assertEquals(min, distinctValues.first());
        assertEquals(max, distinctValues.last());
    }

    @ParameterizedTest
    @MethodSource("argumentsForPairs")
    void shouldReturnPairs(String input, List<Pair> expectedPairs) {
        String[] array = input.split(" ");
        List<Pair> pairs = tasksService.getPairs(array);
        assertEquals(expectedPairs, pairs);
    }

    private static Stream<Arguments> argumentsForDistinctValues() {
        return Stream.of(
                Arguments.of("1 10 20 20 2 5", 5, 1, 20),
                Arguments.of("1", 1, 1, 1),
                Arguments.of("5 5 5", 1, 5, 5),
                Arguments.of("-5 -3 -2 7 9 11", 6, -5, 11)
        );
    }

    private static Stream<Arguments> argumentsForPairs() {
        return Stream.of(
                Arguments.of("1 2 10 7 5 3 6 6 13 0", Arrays.asList(
                        new Pair(0, 13),
                        new Pair(3, 10),
                        new Pair(6, 7),
                        new Pair(6, 7)
                )),
                Arguments.of("1", Collections.emptyList()),
                Arguments.of("13", Collections.emptyList()),
                Arguments.of("5 10 20 -7", Collections.singletonList(new Pair(-7, 20)))
        );
    }
}