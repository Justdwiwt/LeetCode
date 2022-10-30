package main.java;

import java.util.HashSet;
import java.util.Set;

public class Solution_1647 {
    public int minDeletions(String s) {
        int[] cnt = new int[26];
        int res = 0;
        for (char ch : s.toCharArray()) cnt[ch - 'a']++;
        Set<Integer> st = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            int freq = cnt[i];
            while (freq > 0 && !st.add(freq)) {
                freq--;
                res++;
            }
        }
        return res;
    }
}
