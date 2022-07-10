package main.java;

public class Solution_2149 {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length, i = 0, j = 0;
        int[] res = new int[n];
        for (int idx = 0; idx < n; idx++) {
            while (i < n && nums[i] < 0) i++;
            while (j < n && nums[j] > 0) j++;
            res[idx] = idx % 2 == 0 ? nums[i++] : nums[j++];
        }
        return res;
    }
}
