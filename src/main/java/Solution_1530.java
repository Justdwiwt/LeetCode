package main.java;

import java.util.stream.IntStream;

public class Solution_1530 {
    private int res;

    public int countPairs(TreeNode root, int distance) {
        dfs(root, distance);
        return res;
    }

    private int[] dfs(TreeNode root, int dis) {
        if (null == root) return new int[dis + 1];
        int[] cnt = new int[dis + 1];
        if (root.left == null && root.right == null) {
            cnt[0] = 1;
            return cnt;
        }
        int[] left = dfs(root.left, dis);
        int[] right = dfs(root.right, dis);
        for (int i = 0; i < dis; i++)
            for (int j = 0; i + j + 2 <= dis; j++)
                res += left[i] * right[j];
        IntStream.rangeClosed(1, dis).forEach(i -> cnt[i] = left[i - 1] + right[i - 1]);
        return cnt;
    }
}
