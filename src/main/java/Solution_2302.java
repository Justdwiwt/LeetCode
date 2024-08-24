package main.java;

public class Solution_2302 {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        long sum = 0, res = 0L;
        for (int i = 0, j = 0; j < n; j++) {
            sum += nums[j];
            while (i <= j && sum * (j - i + 1) >= k) sum -= nums[i++];
            res += j - i + 1;
        }
        return res;
    }
}
