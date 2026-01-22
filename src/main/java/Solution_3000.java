package main.java;

public class Solution_3000 {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int sq = 0, ans = 0;
        for (int[] a : dimensions) {
            int b = a[0] * a[0] + a[1] * a[1];
            if (b > sq) {
                sq = b;
                ans = a[0] * a[1];
            } else if (b == sq) ans = Math.max(ans, a[0] * a[1]);
        }
        return ans;
    }
}
