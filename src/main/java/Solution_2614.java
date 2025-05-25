package main.java;

public class Solution_2614 {
    private boolean check(int x) {
        if (x == 1) return false;
        for (int i = 2; i * i <= x; i++)
            if (x % i == 0) return false;
        return true;
    }

    public int diagonalPrime(int[][] nums) {
        int i = 0, n = nums.length;
        int res = 0;
        while (i < n) {
            if (check(nums[i][i])) res = Math.max(res, nums[i][i]);
            if (check(nums[i][n - i - 1])) res = Math.max(res, nums[i][n - i - 1]);
            i++;
        }
        return res;
    }
}
