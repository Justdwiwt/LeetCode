package main.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class Solution_2747 {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int m = logs.length;
        int p = queries.length;
        int[] ans = new int[p];
        int[] count = new int[n + 5];
        int num = 0;
        Integer[] idx = IntStream.range(0, p).boxed().toArray(Integer[]::new);
        Arrays.sort(idx, Comparator.comparingInt(a -> queries[a]));
        Arrays.sort(logs, Comparator.comparingInt(a -> a[1]));
        for (int i = 0, l = 0, r = 0; i < p; i++) {
            while (r < m && logs[r][1] <= queries[idx[i]]) {
                count[logs[r][0]]++;
                if (count[logs[r][0]] == 1) num++;
                r++;
            }
            while (l < m && logs[l][1] < queries[idx[i]] - x) {
                count[logs[l][0]]--;
                if (count[logs[l][0]] == 0) num--;
                l++;
            }
            ans[idx[i]] = n - num;
        }
        return ans;
    }
}
