package main.java;

import java.util.stream.IntStream;

public class Solution_1870 {
    public int minSpeedOnTime(int[] dist, double hour) {
        int l = 1;
        int r = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        while (l < r) {
            int mid = (l + r) >>> 1;
            boolean flag = check(mid, dist, hour);
            if (flag) {
                r = mid;
                res = Math.min(res, mid);
            } else l = mid + 1;
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private boolean check(int sp, int[] dist, double hour) {
        double res = IntStream.range(0, dist.length - 1).mapToDouble(i -> Math.ceil(((double) dist[i]) / sp)).sum();
        res += ((double) dist[dist.length - 1]) / sp;
        return res <= hour;
    }
}
