package main.java;

public class Solution_2928 {
    public int distributeCandies(int n, int limit) {
        int ans = 0;
        int hi = Math.min(limit, n);
        for (int mid = 0; mid <= hi; mid++) {
            int m = n - mid, l = Math.max(0, m - hi), r = Math.min(hi, m);
            ans += Math.max(r - l + 1, 0);
        }
        return ans;
    }
}
