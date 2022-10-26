package main.java;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_1665 {
    public int minimumEffort(int[][] tasks) {
        int res = 0, sum = 0;
        Arrays.sort(tasks, Comparator.comparingInt(o -> (o[0] - o[1])));

        for (int[] task : tasks) {
            res = Math.max(res, sum + task[1]);
            sum += task[0];
        }

        return res;
    }
}
