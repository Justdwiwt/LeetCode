package main.java;

public class Solution_2815 {
    public int maxSum(int[] nums) {
        int[] mx = new int[10];
        int ans = -1;
        for (int num : nums) {
            int maxDigit = -1;
            for (int x = num; x > 0; x /= 10) maxDigit = Math.max(maxDigit, x % 10);
            if (mx[maxDigit] > 0) ans = Math.max(mx[maxDigit] + num, ans);
            mx[maxDigit] = Math.max(mx[maxDigit], num);
        }
        return ans;
    }
}
