package main.java;

public class Solution_485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, cur = 0;
        for (int num : nums) {
            cur = ++cur * num;
            if (cur > max) max = cur;
        }
        return max;
    }
}
