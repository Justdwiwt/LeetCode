package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Solution_2049 {
    int[] cnt;
    List<Integer>[] children;

    public int countHighestScoreNodes(int[] parents) {
        int n = parents.length;
        children = new List[n];
        cnt = new int[n];
        IntStream.range(0, n).forEach(i -> children[i] = new ArrayList<>());
        IntStream.range(1, n).forEach(i -> children[parents[i]].add(i));
        dfs(0);
        long mx = 0L;
        int res = 0;
        for (int i = 0; i < n; i++) {
            long cur = Math.max(1L, n - cnt[i]);
            cur *= children[i].stream().mapToInt(son -> son).mapToLong(son -> cnt[son]).reduce(1, (a, b) -> a * b);
            if (cur > mx) {
                mx = cur;
                res = 1;
            } else if (cur == mx) res++;
        }
        return res;
    }

    private void dfs(int ptr) {
        int res = 1;
        for (int son : children[ptr]) {
            dfs(son);
            res += cnt[son];
        }
        cnt[ptr] = res;
    }
}
