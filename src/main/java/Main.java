import services.ITasksService;
import services.impl.TasksService;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    private void run() {
        ITasksService tasksService = new TasksService();
        try {
            tasksService.runTask1();
        } catch (IOException | IllegalArgumentException exception) {
            System.err.println(exception.getMessage());
        }

    }
}
