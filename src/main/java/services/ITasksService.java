package services;

import models.Pair;

import java.util.List;
import java.util.SortedSet;

public interface ITasksService {

    public SortedSet<Integer> getDistinctValues(String[] array) throws NumberFormatException;

    public List<Pair> getPairs(String[] array) throws NumberFormatException;
}
