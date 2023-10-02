package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Solution_386 {
    List<Integer> res = new ArrayList<>();

    public List<Integer> lexicalOrder(int n) {
        IntStream.rangeClosed(1, 9).forEach(i -> dfs(i, n));
        return res;
    }

    public void dfs(int cur, int n) {
        if (cur > n) return;
        res.add(cur);
        IntStream.rangeClosed(0, 9).forEach(i -> dfs(cur * 10 + i, n));
    }
}
