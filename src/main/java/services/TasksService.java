package services;

import models.Pair;

import java.util.List;
import java.util.SortedSet;

public interface TasksService {

    SortedSet<Integer> getDistinctValues(String[] array);

    List<Pair> getPairs(String[] array);

    Integer getNumberOfSeparatedGraphs(SortedSet<Pair> edges);
}
