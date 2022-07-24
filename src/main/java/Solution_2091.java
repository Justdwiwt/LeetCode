package main.java;

public class Solution_2091 {
    public int minimumDeletions(int[] nums) {
        int max = 0, min = 0;
        for (int i = 1; i < nums.length; i++) {
            max = nums[i] > nums[max] ? i : max;
            min = nums[i] < nums[min] ? i : min;
        }
        int front = Math.max(max, min) + 1;
        int back = nums.length - Math.min(max, min);
        int both = Math.min(max, min) + 1 + nums.length - Math.max(min, max);
        return Math.min(both, Math.min(front, back));
    }
}
