package main.java;

import java.util.Arrays;

public class Solution_2412 {
    public long minimumMoney(int[][] transactions) {
        long ans = 0;
        long neg = Arrays.stream(transactions).mapToLong(transaction -> Math.max(0, transaction[0] - transaction[1])).sum();
        for (int[] transaction : transactions) ans = Math.max(ans, neg + Math.min(transaction[0], transaction[1]));
        return ans;
    }
}
