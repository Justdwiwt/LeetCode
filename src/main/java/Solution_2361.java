package main.java;

public class Solution_2361 {
    public long[] minimumCosts(int[] regular, int[] express, int expressCost) {
        int n = regular.length;
        long[] ans = new long[n];
        long a = 0, b = expressCost;
        for (int i = 1; i <= n; i++) {
            long na, nb;
            na = Math.min(a, b) + regular[i - 1];
            nb = Math.min(b, a + expressCost) + express[i - 1];
            ans[i - 1] = Math.min(na, nb);
            a = na;
            b = nb;
        }
        return ans;
    }
}
