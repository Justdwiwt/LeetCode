package main.java;

import java.util.Arrays;

public class Solution_2188 {
    public int minimumFinishTime(int[][] tires, int changeTime, int numLaps) {
        long[] minTime = new long[20];
        Arrays.fill(minTime, Integer.MAX_VALUE);
        for (int[] tire : tires) {
            long t = tire[0];
            long sum = t;
            minTime[1] = Math.min(minTime[1], sum);
            for (int j = 2; ; j++) {
                t *= tire[1];
                if (t >= tire[0] + changeTime) {
                    break;
                }
                sum += t;
                minTime[j] = Math.min(minTime[j], sum);
            }
        }
        long[] res = new long[numLaps + 1];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0] = -changeTime;
        for (int i = 1; i <= numLaps; i++)
            for (int j = 1; j < 20 && i - j >= 0; j++)
                res[i] = Math.min(res[i], minTime[j] + res[i - j] + changeTime);
        return (int) res[numLaps];
    }
}
