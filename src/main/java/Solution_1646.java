package main.java;

public class Solution_1646 {
    public int getMaximumGenerated(int n) {
        if (n < 2) return n;
        int[] p = new int[n + 1];
        p[0] = 0;
        p[1] = 1;
        int maxNum = 0;
        for (int i = 2; i <= n; i++) {
            p[i] = i % 2 == 0 ? p[i / 2] : (p[i / 2] + p[(i + 1) / 2]);
            maxNum = Math.max(maxNum, p[i]);
        }
        return maxNum;
    }
}
