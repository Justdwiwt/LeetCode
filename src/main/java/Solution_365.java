package main.java;

import java.util.HashSet;
import java.util.Set;

public class Solution_365 {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if (targetCapacity > jug1Capacity + jug2Capacity) return false;
        int n = jug1Capacity + jug2Capacity;
        jug1Capacity = Math.min(jug1Capacity, jug2Capacity);
        jug2Capacity = n - jug1Capacity;
        return dfs(jug1Capacity, jug2Capacity, targetCapacity);
    }

    Set<Integer> set = new HashSet<>();

    private boolean dfs(int a, int b, int t) {
        if (a == 0 || b == 0) return false;
        int k = b % a;
        if (set.contains(k)) return false;
        if ((t - k) % a == 0 || (t - k) % b == 0 || (t - (a - k)) % a == 0 || (t - (a - k)) % b == 0) return true;
        set.add(k);
        return dfs(k, b, t) || dfs(k, a, t);
    }
}
