package main.java;

import java.util.stream.IntStream;

public class Solution_2483 {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int[] left = new int[n + 1], right = new int[n + 1];
        IntStream.range(0, n).forEach(i -> {
            left[i + 1] = left[i] + (customers.charAt(i) == 'N' ? 1 : 0);
            right[n - i - 1] = right[n - i] + (customers.charAt(n - i - 1) == 'Y' ? 1 : 0);
        });
        int ans = 0, min = left[0] + right[0];
        for (int i = 1; i <= n; i++)
            if (left[i] + right[i] < min) {
                ans = i;
                min = left[i] + right[i];
            }
        return ans;
    }
}
