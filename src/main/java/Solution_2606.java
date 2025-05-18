package main.java;

import java.util.stream.IntStream;

public class Solution_2606 {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        int n = s.length(), m = vals.length;
        int[] cost = IntStream.range(0, 26).map(i -> i + 1).toArray();
        IntStream.range(0, m).forEach(i -> cost[chars.charAt(i) - 'a'] = vals[i]);
        int ans = 0, f = 0;
        for (int i = 0; i < n; i++) {
            int now = cost[s.charAt(i) - 'a'];
            f = Math.max(f, 0) + now;
            ans = Math.max(ans, f);
        }
        return ans;
    }
}
