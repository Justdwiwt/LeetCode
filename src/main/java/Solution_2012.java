package main.java;

public class Solution_2012 {
    public int sumOfBeauties(int[] nums) {
        int len = nums.length;
        int[] arr = new int[len + 1];
        arr[len] = Integer.MAX_VALUE;

        for (int i = len - 1; i >= 0; i--)
            arr[i] = Math.min(arr[i + 1], nums[i]);

        int cnt = 0;
        for (int lmax = nums[0], i = 1; i < len - 1; i++) {
            if (lmax < nums[i] && nums[i] < arr[i + 1])
                cnt += 2;
            else if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1])
                cnt++;
            lmax = Math.max(lmax, nums[i]);
        }
        return cnt;
    }
}
