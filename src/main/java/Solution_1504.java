package main.java;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_1504 {
    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] upCnt = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (mat[i][j] == 1)
                    upCnt[i][j] = i == 0 ? mat[i][j] & 1 : upCnt[i - 1][j] + 1;
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        for (int i = 0; i < m; i++) {
            stack.clear();
            int ijCnt = 0;
            for (int j = 0; j < n; j++) {
                ijCnt += upCnt[i][j];
                while (!stack.isEmpty() && upCnt[i][stack.peek()] > upCnt[i][j]) {
                    int cur = stack.pop();
                    int left = stack.isEmpty() ? -1 : stack.peek();
                    ijCnt -= (cur - left) * (upCnt[i][cur] - upCnt[i][j]);
                }
                stack.push(j);
                res += ijCnt;
            }
        }
        return res;
    }
}
