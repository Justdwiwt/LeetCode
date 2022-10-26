package main.java;

import java.util.stream.IntStream;

public class Solution_1664 {
    public int waysToMakeFair(int[] nums) {
        int n = nums.length, cnt = 0;
        int[] nxt = new int[2];
        IntStream.range(0, n).forEach(i -> nxt[i & 1] += nums[i]);
        for (int i = 0; i < n; i++) {
            nxt[i & 1] -= nums[i];
            if (nxt[i & 1] == nxt[(i + 1) & 1]) cnt++;
            nxt[(i + 1) & 1] += nums[i];
        }
        return cnt;
    }
}
