package main.java;

import java.util.Arrays;

public class Solution_2064 {
    public int minimizedMaximum(int n, int[] quantities) {
        int m = quantities.length;
        Arrays.sort(quantities);
        int low = 1, high = 0, mid, maxProduct = Integer.MAX_VALUE;
        for (int quantity : quantities) high = Math.max(high, quantity);
        if (m == n) return high;
        while (low <= high) {
            mid = (low + high) >>> 1;
            if (isDistributionPossible(quantities, n, mid)) {
                maxProduct = Math.min(maxProduct, mid);
                high = (mid - 1);
            } else low = (mid + 1);
        }
        return maxProduct;
    }

    private boolean isDistributionPossible(int[] quantities, int n, int w) {
        int cnt = 0;
        for (int quantity : quantities) {
            cnt += (quantity / w);
            if ((quantity % w) != 0) cnt++;
        }
        return (cnt <= n);
    }
}
