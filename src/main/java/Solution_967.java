package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Solution_967 {
    List<Integer> res;

    public int[] numsSameConsecDiff(int n, int k) {
        res = new ArrayList<>();
        dfs(n, k, new StringBuilder());
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private void dfs(int n, int k, StringBuilder str) {
        if (str.length() == n) {
            res.add(Integer.parseInt(str.toString()));
            return;
        }
        IntStream.rangeClosed(0, 9)
                .filter(i -> str.length() != 0 || i != 0)
                .filter(i -> str.length() == 0 || Math.abs(str.charAt(str.length() - 1) - '0' - i) == k)
                .forEach(i -> {
                    str.append(i);
                    dfs(n, k, str);
                    str.deleteCharAt(str.length() - 1);
                });
    }
}
