package main.java;

public class Solution_2552 {
    public long countQuadruplets(int[] nums) {
        long res = 0L;
        int[][] presuf = new int[nums.length][nums.length];
        for (int pivot = 1; pivot < nums.length - 1; pivot++) {
            for (int j = 1; j < pivot; j++)
                presuf[j][pivot] = presuf[j - 1][pivot] + (nums[j - 1] < nums[pivot] ? 1 : 0);
            for (int k = nums.length - 2; k > pivot; k--)
                presuf[k][pivot] = presuf[k + 1][pivot] + (nums[k + 1] > nums[pivot] ? 1 : 0);
        }
        for (int j = 1; j < nums.length - 2; j++)
            for (int k = j + 1; k < nums.length - 1; k++)
                if (nums[k] < nums[j]) res += (long) presuf[j][k] * presuf[k][j];
        return res;
    }
}
