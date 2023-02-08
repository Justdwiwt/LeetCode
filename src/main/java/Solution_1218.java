package main.java;

import java.util.HashMap;

public class Solution_1218 {
    public int longestSubsequence(int[] arr, int difference) {
        int max = 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int j : arr) {
            Integer val = map.get(j - difference);
            if (val != null) {
                map.put(j, val + 1);
                max = Math.max(max, val + 1);
            } else map.put(j, 1);
        }
        return max;
    }
}
