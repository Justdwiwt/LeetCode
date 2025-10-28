package main.java;

public class Solution_2874 {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long maxSum = 0;
        long max = 0;
        long index = 0;
        for (int num : nums) {
            maxSum = Math.max(maxSum, max * num);
            max = Math.max(max, index - num);
            index = Math.max(index, num);
        }
        return maxSum;
    }
}
