package main.java;

public class Solution_3024 {
    public String triangleType(int[] nums) {
        return ((nums[1] + nums[2] <= nums[0])
                || (nums[1] + nums[0] <= nums[2])
                || (nums[0] + nums[2] <= nums[1]))
                ? "none" : (nums[0] == nums[1]
                ? (nums[1] == nums[2]
                ? "equilateral" : "isosceles") : ((nums[0] == nums[2] || nums[1] == nums[2])
                ? "isosceles" : "scalene"));
    }
}
