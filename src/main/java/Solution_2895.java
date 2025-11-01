package main.java;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution_2895 {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        Collections.sort(processorTime);
        Collections.sort(tasks, Comparator.reverseOrder());
        int result = 0;
        for (int index = 0; index < processorTime.size(); index++)
            result = Math.max(result, processorTime.get(index) + tasks.get(index << 2));
        return result;
    }
}
