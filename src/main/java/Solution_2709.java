package main.java;

import java.util.stream.IntStream;

public class Solution_2709 {
    private int[] fa;

    private int find(int x) {
        if (fa[x] != x) fa[x] = find(fa[x]);
        return fa[x];
    }

    private void merge(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) return;
        fa[x] = y;
    }

    public boolean canTraverseAllPairs(int[] nums) {
        int n = nums.length;
        if (n == 1) return true;

        int m = 0;
        for (int num : nums) {
            if (num == 1) return false;
            m = Math.max(m, num);
        }

        fa = new int[m + 1];
        IntStream.rangeClosed(0, m).forEach(i -> fa[i] = i);
        for (int num : nums) {
            int tmp = num;
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    merge(i, tmp);
                    while (num % i == 0) num /= i;
                }
            }

            if (num > 1) merge(num, tmp);
        }

        int r = find(nums[0]);

        return IntStream.range(1, n).noneMatch(i -> find(nums[i]) != r);
    }
}
