package main.java;

import java.util.Arrays;

public class Solution_1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] dif = new int[1001];
        Arrays.stream(trips).forEach(trip -> {
            dif[trip[1]] += trip[0];
            dif[trip[2]] -= trip[0];
        });
        for (int i = 0; i <= 1000; ++i) {
            capacity -= dif[i];
            if (capacity < 0) return false;
        }
        return true;
    }
}
