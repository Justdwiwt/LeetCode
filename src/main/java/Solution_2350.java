package main.java;

import java.util.HashSet;
import java.util.Set;

public class Solution_2350 {
    public int shortestSequence(int[] rolls, int k) {
        Set<Integer> set = new HashSet<>();
        int res = 1;
        for (int roll : rolls) {
            set.add(roll);
            if (set.size() == k) {
                res++;
                set.clear();
            }
        }
        return res;
    }
}
