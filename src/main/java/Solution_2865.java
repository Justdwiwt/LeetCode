package main.java;

public class Solution_2865 {
    public long maximumSumOfHeights(int[] maxHeights) {
        long res = 0;
        for (int p = 0; p < maxHeights.length; p++) {
            long curRes = maxHeights[p];
            int cur = maxHeights[p];
            for (int i = p - 1; i >= 0; i--) {
                cur = Math.min(cur, maxHeights[i]);
                curRes += cur;
            }
            cur = maxHeights[p];
            for (int i = p + 1; i < maxHeights.length; i++) {
                cur = Math.min(cur, maxHeights[p]);
                curRes += cur;
            }
            res = Math.max(res, curRes);
        }
        return res;
    }
}
