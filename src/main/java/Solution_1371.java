package main.java;

import java.util.Arrays;

public class Solution_1371 {
    public int findTheLongestSubstring(String s) {
        int[] arr = new int[32];
        Arrays.fill(arr, -2);
        arr[0] = -1;
        String diff = "aeiou";
        int res = 0, state = 0;
        for (int i = 0; i < s.length(); i++) {
            int k = diff.indexOf(s.charAt(i));
            if (k != -1) state ^= 1 << k;
            if (arr[state] != -2) res = Math.max(res, i - arr[state]);
            else arr[state] = i;
        }
        return res;
    }
}
