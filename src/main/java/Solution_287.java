package main.java;

public class Solution_287 {
    public int findDuplicate(int[] nums) {
        while (nums[0] != nums[nums[0]]) {
            int temp = nums[0];
            nums[0] = nums[nums[0]];
            nums[temp] = temp;
        }
        return nums[0];
    }
}
