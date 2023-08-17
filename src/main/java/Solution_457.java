package main.java;

public class Solution_457 {
    public boolean circularArrayLoop(int[] nums) {
        int idx = 0, n = nums.length, success = 1001, st = 0;
        while (idx < n) {
            int temp = idx;
            idx = (idx + nums[idx] + 1000 * n) % n;
            int t = nums[temp];
            nums[temp] = success;
            if (idx == temp) {
                while (st < n && nums[st] > 1000) st++;
                idx = st;
                success++;
            } else if (nums[idx] == success) return true;
            else if (nums[idx] * t < 0 || nums[idx] > 1000) {
                while (st < n && nums[st] > 1000) st++;
                idx = st;
                success++;
            }
        }
        return false;
    }
}
