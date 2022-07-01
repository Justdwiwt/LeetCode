package main.java;

public class Solution_2190 {
    public int mostFrequent(int[] nums, int key) {
        int[] cnt = new int[1001];
        int res = 0;
        for (int i = 0; i < nums.length - 1; i++)
            if (nums[i] == key) {
                cnt[nums[i + 1]]++;
                res = cnt[nums[i + 1]] > cnt[res] ? nums[i + 1] : res;
            }
        return res;
    }
}
