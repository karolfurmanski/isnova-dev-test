package services.impl;

import services.ITasksService;
import utils.InputUtils;
import utils.NumberUtils;

import java.io.IOException;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class TasksService implements ITasksService {

    @Override
    public void runTask1() throws IOException, IllegalArgumentException {
        String input = InputUtils.readLine();
        String[] inputArray = input.split(" ");
        SortedSet<Integer> distinctValues = getDistinctValues(inputArray);
        printTask1(distinctValues, inputArray.length);
    }

    @Override
    public void runTask2() {

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
}
