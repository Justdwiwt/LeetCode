package main.java;

public class Solution_2673 {
    public int minIncrements(int n, int[] cost) {
        return dfs(cost, 1)[0];
    }

    public int[] dfs(int[] cost, int i) {
        if (i > cost.length) {
            return new int[2];
        }
        int[] left = dfs(cost, i << 1);
        int[] right = dfs(cost, i << 1 | 1);
        int max = Math.max(left[1], right[1]);
        return new int[]{left[0] + right[0] + max - Math.min(left[1], right[1]), cost[i - 1] + max};
    }
}
