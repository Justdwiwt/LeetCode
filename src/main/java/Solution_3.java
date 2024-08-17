package main.java;

import java.util.HashSet;
import java.util.Set;

public class Solution_3 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> st = new HashSet<>();
        int n = s.length();
        int cnt = -1, res = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) st.remove(s.charAt(i - 1));
            while (cnt + 1 < n && !st.contains(s.charAt(cnt + 1))) {
                st.add(s.charAt(cnt + 1));
                ++cnt;
            }
            res = Math.max(res, cnt - i + 1);
        }
        return res;
    }
}
