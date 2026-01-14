package main.java;

import java.util.HashMap;
import java.util.Map;

public class Solution_2981 {
    public int maximumLength(String s) {
        int ans = -1;
        Map<String, Integer> map = new HashMap<>();
        char[] cs = s.toCharArray();
        for (int left = 0, right = 0; right <= cs.length; right++)
            if (right == cs.length || cs[left] != cs[right]) {
                int cnt = 1;
                while (left < right) {
                    String sub = s.substring(left, right);
                    int time = map.merge(sub, cnt, Integer::sum);
                    if (time >= 3) ans = Math.max(ans, right - left);
                    cnt++;
                    left++;
                }
            }
        return ans;
    }
}
