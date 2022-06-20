package main.java;

import java.util.Arrays;
import java.util.HashMap;

public class Solution_2244 {
    public int minimumRounds(int[] tasks) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        Arrays.stream(tasks).forEach(i -> map.put(i, map.getOrDefault(i, 0) + 1));
        for (int i : map.values()) {
            if (i == 1) return -1;
            if (i % 3 == 0) res += i / 3;
            else if ((i - 2) % 3 == 0) res += i / 3 + 1;
            else if (i % 3 == 1) res += (i - 4) / 3 + 2;
            else if (i % 2 == 0) res += i / 2;
        }
        return res;
    }
}
