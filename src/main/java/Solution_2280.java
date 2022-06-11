package main.java;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_2280 {
    public int minimumLines(int[][] stockPrices) {
        Arrays.sort(stockPrices, Comparator.comparingInt(a -> a[0]));
        int len = stockPrices.length;
        int i = 0, cnt = 0;
        while (i < len - 2) {
            int m = i;
            while (m < len - 2 && getMul(stockPrices[i], stockPrices[i + 1], stockPrices[m + 2])) m++;
            i = m + 1;
            cnt++;
        }
        if (i == len - 2) cnt++;
        return cnt;
    }

    private boolean getMul(int[] a, int[] b, int[] c) {
        return (long) (c[1] - b[1]) * (b[0] - a[0]) == (long) (b[1] - a[1]) * (c[0] - b[0]);
    }
}
