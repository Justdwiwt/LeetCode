package main.java;

public class Solution_495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int res = 0;
        int len = timeSeries.length;
        for (int i = 1; i < len; i++)
            res = timeSeries[i] >= timeSeries[i - 1] + duration ? res + duration : res + (timeSeries[i] - timeSeries[i - 1]);
        return res + duration;
    }
}
