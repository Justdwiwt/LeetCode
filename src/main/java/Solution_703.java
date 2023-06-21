package main.java;

public class Solution_703 {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) l = mid + 1;
            else if (nums[mid] > target) r = mid;
        }
        return -1;
    }
}
