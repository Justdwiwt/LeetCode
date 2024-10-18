package main.java;

import java.util.HashMap;
import java.util.Map;

public class Solution_2365 {
    public long taskSchedulerII(int[] tasks, int space) {
        long res = 0;
        Map<Integer, Long> map = new HashMap<>();
        for (int x : tasks) {
            if (map.containsKey(x)) {
                long y = res - map.get(x);
                if (y <= space) res += space - y;
            }
            res++;
            map.put(x, res);
        }
        return res;
    }
}
