package main.java;

import java.util.LinkedList;
import java.util.stream.IntStream;

public class Solution_1687 {
    private int[] sum;

    private int cost(int l, int r) {
        int res = sum[r] - sum[l];
        if (l + 1 <= r && sum[l + 1] == sum[l]) res++;
        return res;
    }

    public int boxDelivering(int[][] boxes, int portsCount, int maxBoxes, int maxWeight) {
        int n = boxes.length;
        sum = new int[n + 10];
        IntStream.rangeClosed(1, n).forEach(i -> {
            sum[i] = sum[i - 1];
            if (i == 1 || boxes[i - 1][0] != boxes[i - 2][0]) sum[i]++;
        });

        int[] dp = new int[n + 10];
        LinkedList<Integer> que = new LinkedList<>();
        que.addLast(0);
        for (int i = 1, j = 1, w = 0; i <= n; i++) {
            w += boxes[i - 1][1];
            while (w > maxWeight || i - j + 1 > maxBoxes) {
                w -= boxes[j - 1][1];
                j++;
            }
            while (!que.isEmpty() && que.getFirst() < j - 1) que.pollFirst();
            if (!que.isEmpty()) {
                Integer k = que.getFirst();
                dp[i] = dp[k] + cost(k, i) + 1;
            }
            while (!que.isEmpty() && dp[que.getLast()] >= dp[i]) que.pollLast();
            que.addLast(i);
        }
        return dp[n];
    }
}
