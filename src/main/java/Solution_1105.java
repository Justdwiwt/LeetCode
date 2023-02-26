package main.java;

import java.util.Arrays;

public class Solution_1105 {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] f = new int[n + 1];
        Arrays.fill(f, 0x3f3f3f3f);
        f[0] = 0;
        for (int i = 1; i <= n; i++) {
            int maxH = 0, sumW = 0;
            for (int j = i - 1; j >= 0; j--) {
                int w = books[j][0], h = books[j][1];
                if (sumW + w <= shelfWidth) {
                    maxH = Math.max(maxH, h);
                    sumW += w;
                    f[i] = Math.min(f[i], maxH + f[j]);
                } else break;
            }
        }
        return f[n];
    }
}
