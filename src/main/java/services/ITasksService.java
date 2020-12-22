package services;

import java.io.IOException;

public interface ITasksService {

    public void runTask1() throws IOException, IllegalArgumentException;

    public void runTask2() throws IOException, IllegalArgumentException;

    public void runTask3();
}
