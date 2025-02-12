package main.java;

import java.util.Arrays;

public class Solution_2501 {
    public int longestSquareStreak(int[] nums) {
        int[] arr = new int[(int) 1e5 + 10];
        Arrays.stream(nums).forEach(x -> arr[x] = 1);
        Arrays.sort(nums);
        int ans = 1;
        for (int num : nums) {
            int temp = 1;
            if (num > 316) break;
            int a = num * num;
            while (arr[a] != 0) {
                temp++;
                if (a > 316) break;
                a *= a;
            }
            ans = Math.max(ans, temp);
        }
        return ans == 1 ? -1 : ans;
    }
}
