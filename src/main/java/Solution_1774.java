package main.java;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution_1774 {
    private int M = (int) 1e9;
    private int target;

    public int closestCost(int[] b, int[] t, int target) {
        this.target = target;
        Arrays.stream(b).forEach(j -> dfs(t, 0, j));
        return M;
    }

    private void dfs(int[] arr, int idx, int total) {
        int sign = Math.abs(M - target) - Math.abs(total - target);
        if (sign > 0 || (sign == 0 && total < M)) M = total;
        if (total >= target || idx == arr.length) return;
        IntStream.range(0, 3).forEach(k -> dfs(arr, idx + 1, total + arr[idx] * k));
    }
}
