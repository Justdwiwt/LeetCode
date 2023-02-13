package main.java;

import java.util.HashMap;
import java.util.Map;

public class Solution_1189 {
    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> map = new HashMap<>();
        char[] x = "balloon".toCharArray();
        for (char xx : text.toCharArray())
            map.put(xx, map.getOrDefault(xx, 0) + 1);
        int res = 0;
        while (true) {
            for (char c : x) {
                int count = map.getOrDefault(c, 0);
                if (count <= 0) return res;
                map.put(c, count - 1);
            }
            ++res;
        }
    }
}
