package main.java;

import java.util.*;
import java.util.stream.Collectors;

public class Solution_711 {
    static class Solution {

        Random random = new Random();
        Map<Integer, Integer> map = new HashMap<>();
        int bound;

        public Solution(int n, int[] blacklist) {
            bound = n - blacklist.length;
            Set<Integer> blacks = Arrays.stream(blacklist).filter(b -> b >= bound).boxed().collect(Collectors.toSet());
            int w = bound;
            for (int b : blacklist)
                if (b < bound) {
                    while (blacks.contains(w)) w++;
                    map.put(b, w);
                    w++;
                }
        }

        public int pick() {
            int x = random.nextInt(bound);
            return map.getOrDefault(x, x);
        }
    }
}
