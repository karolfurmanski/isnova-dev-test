package services.impl;

import models.Pair;
import services.TasksService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class TasksServiceImpl implements TasksService {

    private static final Integer TARGET_SUM = 13;

    @Override
    public SortedSet<Integer> getDistinctValues(String[] array) {
        SortedSet<Integer> distinctValues = new TreeSet<>();
        int i = 0;
        int j = array.length - 1;

        while (i <= j) {
            distinctValues.add(Integer.parseInt(array[i]));
            if (i != j)
                distinctValues.add(Integer.parseInt(array[j]));
            i++;
            j--;
        }

        return distinctValues;
    }

    @Override
    public List<Pair> getPairs(String[] array) {
        TreeMap<Integer, Integer> distinctValuesWithCounts = getDistinctValuesWithCounts(array);
        return convertToPairs(distinctValuesWithCounts);
    }

    @Override
    public Integer getNumberOfSeparatedGraphs(SortedSet<Pair> edges) {
        if (Objects.isNull(edges)) {
            throw new IllegalArgumentException("Input cannot be null");
        }
        Iterator<Pair> iterator = edges.iterator();
        Pair previousPair = null;
        int numberOfGraphs = 0;
        HashSet<Integer> vertices = new HashSet<>();

        while (iterator.hasNext()) {
            Pair pair = iterator.next();
            if (isNewGraph(previousPair, pair, vertices)) {
                numberOfGraphs++;
            }
            vertices.add(pair.getFirst());
            vertices.add(pair.getSecond());
            previousPair = pair;
        }
        return numberOfGraphs;
    }

    private TreeMap<Integer, Integer> getDistinctValuesWithCounts(String[] array) {
        TreeMap<Integer, Integer> result = new TreeMap<>();

        for (String item : array) {
            Integer key = Integer.parseInt(item);
            Integer count = result.get(key);

            if (Objects.nonNull(count)) {
                result.put(key, count + 1);
            } else {
                result.put(key, 1);
            }
        }
        return result;
    }

    private List<Pair> convertToPairs(TreeMap<Integer, Integer> valuesWithCounts) {
        List<Pair> pairs = new ArrayList<>();

        valuesWithCounts.forEach((key, value) -> {
            Integer difference = TARGET_SUM - key;
            Integer count = valuesWithCounts.get(difference);

            if (Objects.nonNull(value) && Objects.nonNull(count)) {
                int numberOfIterations = value * count;
                for (int i = 0; i < numberOfIterations; i++) {
                    pairs.add(new Pair(key, difference));
                }
                valuesWithCounts.put(difference, null);
            }
        });
        return pairs;
    }

    private boolean isNewGraph(Pair previousPair, Pair pair, HashSet<Integer> vertices) {
        return isFirstEdge(previousPair) || (pairsNotConnected(previousPair, pair) && isNewVertices(pair, vertices));
    }

    private boolean isFirstEdge(Pair previousPair) {
        return Objects.isNull(previousPair);
    }

    private boolean pairsNotConnected(Pair previousPair, Pair pair) {
        return !previousPair.getSecond().equals(pair.getFirst()) &&
                !previousPair.getFirst().equals(pair.getSecond()) &&
                !previousPair.getSecond().equals(pair.getSecond()) &&
                !previousPair.getFirst().equals(pair.getFirst());
    }

    private boolean isNewVertices(Pair pair, HashSet<Integer> vertices) {
        return !vertices.contains(pair.getFirst()) &&
                !vertices.contains(pair.getSecond());
    }
}
