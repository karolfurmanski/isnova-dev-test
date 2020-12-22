package services.impl;

import services.ITasksService;
import utils.InputUtils;
import utils.NumberUtils;

import java.io.IOException;
import java.util.*;

public class TasksService implements ITasksService {

    private static final Integer SUM = 13;

    @Override
    public void runTask1() throws IOException, IllegalArgumentException {
        String[] inputArray = InputUtils.getInputArray();
        SortedSet<Integer> distinctValues = getDistinctValues(inputArray);
        printTask1(distinctValues, inputArray.length);
    }

    @Override
    public void runTask2() throws IOException, IllegalArgumentException {
        String[] inputArray = InputUtils.getInputArray();
        TreeMap<Integer, Integer> distinctValuesWithCounts = getDistinctValuesWithCount(inputArray);
        printTask2(distinctValuesWithCounts);
    }

    private SortedSet<Integer> getDistinctValues(String[] array) throws NumberFormatException {
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

    private TreeMap<Integer, Integer> getDistinctValuesWithCount(String[] array) throws NumberFormatException {
        TreeMap<Integer, Integer> result = new TreeMap<>();

        for (String item : array) {
            Integer key = NumberUtils.parseInt(item);
            Integer count = result.get(key);

            if (key > SUM) continue;

            if (Objects.nonNull(count))
                result.put(key, count + 1);
            else
                result.put(key, 1);
        }
        return result;
    }

    private void printTask1(SortedSet<Integer> distinctValues, Integer count) {
        Iterator<Integer> iterator = distinctValues.iterator();

        while (iterator.hasNext()) {
            System.out.print(iterator.next());
            if (iterator.hasNext())
                System.out.print(" ");
            else
                System.out.println();
        }

        System.out.println("count: " + count);
        System.out.println("distinct: " + distinctValues.size());
        System.out.println("min: " + distinctValues.first());
        System.out.println("max: " + distinctValues.last());
    }

    private void printTask2(TreeMap<Integer, Integer> treeMap) {
        treeMap.forEach((key, value) -> {
            Integer difference = SUM - key;
            Integer count = treeMap.get(difference);

            if (Objects.nonNull(value) && Objects.nonNull(count)) {
                int numberOfIterations = value * count;
                for (int i = 0; i < numberOfIterations; i++) {
                    System.out.println(key + " " + difference);
                }
                treeMap.put(difference, null);
            }
        });
    }
}
