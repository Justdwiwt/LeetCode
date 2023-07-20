package main.java;

public class Solution_565 {
    public int arrayNesting(int[] nums) {
        int n = nums.length;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            int idx = i, cnt = 0;
            while (!(nums[idx] < 0) && !(nums[idx] >= n)) {
                cnt++;
                int c = idx;
                idx = nums[idx];
                nums[c] = -1;
            }
            maxLen = Math.max(maxLen, cnt);
        }
        return maxLen;
    }
}
