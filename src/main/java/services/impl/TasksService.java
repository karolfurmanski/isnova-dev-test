package services.impl;

import models.Pair;
import services.ITasksService;
import utils.NumberUtils;

import java.util.*;

public class TasksService implements ITasksService {

    private static final Integer SUM = 13;

    @Override
    public SortedSet<Integer> getDistinctValues(String[] array) throws NumberFormatException {
        SortedSet<Integer> distinctValues = new TreeSet<>();
        int i = 0;
        int j = array.length - 1;

        while (i <= j) {
            distinctValues.add(NumberUtils.parseInt(array[i]));
            if (i != j)
                distinctValues.add(NumberUtils.parseInt(array[j]));
            i++;
            j--;
        }

        return distinctValues;
    }

    @Override
    public List<Pair> getPairs(String[] array) throws NumberFormatException {
        TreeMap<Integer, Integer> distinctValuesWithCounts = getDistinctValuesWithCounts(array);
        return getPairs(distinctValuesWithCounts);
    }

    private TreeMap<Integer, Integer> getDistinctValuesWithCounts(String[] array) throws NumberFormatException {
        TreeMap<Integer, Integer> result = new TreeMap<>();

        for (String item : array) {
            Integer key = NumberUtils.parseInt(item);
            Integer count = result.get(key);

            if (Objects.nonNull(count))
                result.put(key, count + 1);
            else
                result.put(key, 1);
        }
        return result;
    }

    private List<Pair> getPairs(TreeMap<Integer, Integer> valuesWithCounts) {
        List<Pair> pairs = new ArrayList<>();

        valuesWithCounts.forEach((key, value) -> {
            Integer difference = SUM - key;
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
}
