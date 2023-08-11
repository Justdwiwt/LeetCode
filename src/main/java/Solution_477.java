package main.java;

public class Solution_477 {
    public int totalHammingDistance(int[] nums) {
        int res = 0;
        int n = nums.length;
        for (int i = 0; i < 30; i++) {
            int oneCount = 0;
            int temp = 0;
            for (int j = 0; j < n; j++) {
                oneCount += nums[j] & 1;
                nums[j] >>= 1;
                temp += nums[j] == 0 ? 1 : 0;
            }
            res += oneCount * (n - oneCount);
            if (temp == n) break;
        }
        return res;
    }
}
