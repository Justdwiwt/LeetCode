package main.java;

public class Solution_2871 {
    public int maxSubarrays(int[] nums) {
        int cnt = 0, sum = 0xfffff;
        for (int num : nums) {
            sum &= num;
            if (sum == 0) {
                cnt++;
                sum = 0xfffff;
            }
        }
        return cnt == 0 ? 1 : cnt;
    }
}
