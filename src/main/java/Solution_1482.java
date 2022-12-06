package main.java;

public class Solution_1482 {
    public int minDays(int[] bloomDay, int m, int k) {
        int l = 1, r = (int) 1e9;
        if ((long) m * (long) k > (long) bloomDay.length) return -1;
        while (l < r) {
            int mid = (l + r) >>> 1;
            int f = 0, b = 0;
            for (int d : bloomDay)
                if (d > mid) f = 0;
                else if (++f == k) {
                    b++;
                    f = 0;
                }
            if (b < m) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}
