package main.java;

import java.util.Arrays;

public class Solution_1672 {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int[] account : accounts) {
            int sum = Arrays.stream(account).sum();
            max = Math.max(sum, max);
        }
        return max;
    }
}
