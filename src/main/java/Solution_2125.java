package main.java;

import java.util.stream.IntStream;

public class Solution_2125 {
    public int numberOfBeams(String[] bank) {
        int n = bank.length, res = 0;
        int[] nums = IntStream.range(0, n).map(i -> count(bank[i])).toArray();
        for (int i = 0; i < n - 1; i++) {
            int j = i + 1;
            while (j < n - 1 && nums[j] == 0) j++;
            res += nums[j] * nums[i];
        }
        return res;
    }

    private static int count(String s) {
        int res = 0;
        for (char ch : s.toCharArray())
            if (ch == '1') res++;
        return res;
    }
}
