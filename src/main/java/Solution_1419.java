package main.java;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Solution_1419 {
    public int minNumberOfFrogs(String croakOfFrogs) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('c', 0);
        map.put('r', 1);
        map.put('o', 2);
        map.put('a', 3);
        map.put('k', 4);
        int[] count = new int[6];
        count[0] = 20005;
        int res = 0;
        for (char c : croakOfFrogs.toCharArray()) {
            int num = findCraok(c, count, map);
            if (num == -1) return -1;
            res = Math.max(res, num);
        }
        for (int i = 1; i <= 4; i++) if (count[i] > 0) return -1;
        return res;
    }

    int findCraok(char c, int[] count, Map<Character, Integer> map) {
        if (!map.containsKey(c)) return -1;
        int idx = map.get(c);
        if (count[idx] == 0) return -1;
        count[idx]--;
        count[idx + 1]++;
        return IntStream.rangeClosed(1, 4).map(i -> count[i]).sum();
    }
}
