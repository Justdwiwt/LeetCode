package main.java;

import java.util.Arrays;

public class Solution_2323 {
    public int minimumTime(int[] jobs, int[] workers) {
        int minTime = 0;
        Arrays.sort(jobs);
        Arrays.sort(workers);
        int n = jobs.length;
        for (int i = 0; i < n; i++) {
            int currTime = (jobs[i] - 1) / workers[i] + 1;
            minTime = Math.max(minTime, currTime);
        }
        return minTime;
    }
}
