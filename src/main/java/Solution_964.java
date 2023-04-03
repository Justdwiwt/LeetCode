package main.java;

import java.util.HashMap;
import java.util.Map;

public class Solution_964 {
    private Map<String, Long> cache;

    public int leastOpsExpressTarget(int x, int target) {
        cache = new HashMap<>();
        return (int) dfs(x, target);
    }

    private long dfs(long x, long target) {
        if (target == x) return 0;
        if (target == 1) return 1;
        String key = x + "," + target;
        if (cache.containsKey(key)) return cache.get(key);
        long res;
        if (target < x) res = x - target < target ? Math.min(2 * target - 1, 1 + dfs(x, x - target)) : 2 * target - 1;
        else {
            long cnt = 0, num = x;
            while (num < target) {
                num *= x;
                cnt++;
            }
            if (num == target) res = cnt;
            else
                res = num - target < target ? Math.min(cnt + 1 + dfs(x, num - target), cnt + dfs(x, target - num / x)) : cnt + dfs(x, target - num / x);
        }
        cache.put(key, res);
        return res;
    }
}
