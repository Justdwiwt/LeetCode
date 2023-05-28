package main.java;

public class Solution_795 {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int distance = 0, index = 0, endByPreNum = 0, count = 0;
        while (index < nums.length) {
            int cur = nums[index++];
            if (cur > right) {
                distance = endByPreNum = 0;
                continue;
            }
            if (cur >= left) endByPreNum = distance + 1;
            count += endByPreNum;
            distance++;
        }
        return count;
    }
}
