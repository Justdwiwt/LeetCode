package main.java;

public class Solution_2511 {
    public int captureForts(int[] forts) {
        int n = forts.length, l = 0, ans = 0;
        for (int r = 1; r < n; r++) {
            if (forts[l] * forts[r] < 0) ans = Math.max(ans, r - l - 1);
            if (forts[r] != 0) l = r;
        }
        return ans;
    }
}
