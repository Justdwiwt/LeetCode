package main.java;

public class Solution_1558 {
    public int minOperations(int[] nums) {
        int cnt = 0;
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            cnt += Integer.bitCount(num);
        }
        cnt += Integer.toBinaryString(max).length() - 1;
        return cnt;
    }
}
