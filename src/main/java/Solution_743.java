package main.java;

import java.util.Arrays;

public class Solution_743 {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] res = new int[n];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[k - 1] = 0;
        while (true) {
            boolean end = true;
            for (int[] time : times) {
                if (res[time[0] - 1] == Integer.MAX_VALUE) continue;
                if (res[time[0] - 1] + time[2] >= res[time[1] - 1]) continue;
                res[time[1] - 1] = res[time[0] - 1] + time[2];
                end = false;
            }
            if (end) break;
        }
        int num = Arrays.stream(res).max().getAsInt();
        return num == Integer.MAX_VALUE ? -1 : num;
    }
}
