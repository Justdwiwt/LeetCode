package main.java;

import java.util.Arrays;

public class Solution_587 {
    public int[][] outerTrees(int[][] trees) {
        if (trees.length == 1) return trees;
        Arrays.sort(trees, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int[] visited = new int[trees.length];
        int[] stack = new int[trees.length + 1];
        stack[0] = 0;
        int top = 1;
        int i = 1;
        while (i < trees.length) {
            if (top < 2) {
                stack[top++] = i;
                visited[i] = 1;
                i++;
                continue;
            }
            if (compare(trees[stack[top - 2]], trees[stack[top - 1]], trees[i]) < 0) {
                visited[stack[top - 1]] = 0;
                top--;
            } else {
                visited[stack[top]] = 0;
                stack[top++] = i;
                visited[i] = 1;
                i++;
            }
        }
        int m = top;
        i = trees.length - 2;
        while (i >= 0) {
            if (visited[i] == 1) {
                i--;
                continue;
            }
            if (top == m) {
                stack[top++] = i;
                visited[i] = 1;
                i--;
                continue;
            }
            if (compare(trees[stack[top - 2]], trees[stack[top - 1]], trees[i]) < 0) top--;
            else {
                stack[top++] = i;
                i--;
            }
        }
        int[][] res = new int[top - 1][2];
        for (i = 0; i < top - 1; i++) res[i] = trees[stack[i]];
        return res;
    }

    public double compare(int[] a, int[] b, int[] c) {
        if (a[0] == b[0]) return 1;
        double k1 = (double) (b[1] - a[1]) / (b[0] - a[0]);
        double k2 = (double) (c[1] - a[1]) / (c[0] - a[0]);
        return k1 - k2;
    }
}
