package main.java;

public class Solution_2763 {
    public int sumImbalanceNumbers(int[] nums) {
        int n = nums.length, ans = 0;
        for (int i = 0; i < n; i++) {
            boolean has[] = new boolean[n + 5];
            has[nums[i]] = true;
            for (int j = i + 1, k = 0; j < n; j++) {
                if (!has[nums[j]]) {
                    has[nums[j]] = true;
                    if (has[nums[j] + 1] && has[nums[j] - 1]) k--;
                    if (!has[nums[j] + 1] && !has[nums[j] - 1]) k++;
                }
                ans += k;
            }
        }
        return ans;
    }
}
