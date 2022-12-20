package main.java;

import java.util.stream.IntStream;

public class Solution_1422 {
    public int maxScore(String s) {
        int n = s.length();
        int[] preSum = new int[n];
        IntStream.range(0, n).forEach(i -> preSum[i] = (i > 0 ? preSum[i - 1] : 0) + s.charAt(i) - '0');
        int res = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int leftScore = i + 1 - preSum[i], rightScore = preSum[n - 1] - preSum[i];
            res = Math.max(res, leftScore + rightScore);
        }
        return res;
    }
}
