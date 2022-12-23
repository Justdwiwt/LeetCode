package main.java;

public class Solution_1413 {
    public int minStartValue(int[] nums) {
        int min = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            min = Math.min(min, sum);
        }
        return 1 - min;
    }
}
