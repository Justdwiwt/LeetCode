package main.java;

import java.util.HashMap;

public class Solution_1553 {
    HashMap<Integer, Integer> map = new HashMap<>();

    public int minDays(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (map.containsKey(n)) return map.get(n);
        map.put(n, Math.min(minDays(n / 2) + n % 2 + 1, minDays(n / 3) + n % 3 + 1));
        return Math.min(minDays(n / 2) + n % 2 + 1, minDays(n / 3) + n % 3 + 1);
    }
}
