import models.Pair;
import services.ITasksService;
import services.impl.TasksService;
import utils.InputUtils;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;

public class Main {

    private ITasksService tasksService;

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    private void run() {
        tasksService = new TasksService();
        int action = 0;

        do {
            showMenu();

            try {
                action = InputUtils.getInputNumber();
                runTask(action);
            } catch (IOException | IllegalArgumentException exception) {
                System.err.println(exception.getMessage());
            }

        } while (action != 4);
    }

    private void showMenu() {
        System.out.println("\nChoose action:\n");
        System.out.println("1 - Task 1");
        System.out.println("2 - Task 2");
        System.out.println("3 - Task 3");
        System.out.println("4 - Exit");
    }

    private void runTask(int action) throws IOException, IllegalArgumentException {
        switch (action) {
            case 1:
                String[] task1Input = InputUtils.getInputArray();
                SortedSet<Integer> distinctValues = tasksService.getDistinctValues(task1Input);
                printTask1(distinctValues, task1Input.length);
                break;
            case 2:
                String[] task2Input = InputUtils.getInputArray();
                List<Pair> pairs = tasksService.getPairs(task2Input);
                printTask2(pairs);
                break;
            case 3:
                SortedSet<Pair> edges = InputUtils.getInputEdges();
                int numberOfGraphs = tasksService.getNumberOfSeparatedGraphs(edges);
                System.out.println(numberOfGraphs);
        }
    }

    private void printTask1(SortedSet<Integer> distinctValues, int count) {
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

    private void printTask2(List<Pair> pairs) {
        pairs.forEach(pair -> System.out.println(pair.getFirst() + " " + pair.getSecond()));
    }
}
