package main.java;

import java.util.HashMap;
import java.util.Map;

public class Solution_2998 {
    private final Map<Integer, Integer> memo = new HashMap<>();

    public int minimumOperationsToMakeEqual(int x, int y) {
        if (x <= y) return y - x;
        if (memo.containsKey(x)) return memo.get(x);
        int ans = x - y;
        ans = Math.min(ans, minimumOperationsToMakeEqual(x / 11, y) + x % 11 + 1);
        ans = Math.min(ans, minimumOperationsToMakeEqual(x / 11 + 1, y) + 11 - x % 11 + 1);
        ans = Math.min(ans, minimumOperationsToMakeEqual(x / 5, y) + x % 5 + 1);
        ans = Math.min(ans, minimumOperationsToMakeEqual(x / 5 + 1, y) + 5 - x % 5 + 1);
        memo.put(x, ans);
        return ans;
    }
}
