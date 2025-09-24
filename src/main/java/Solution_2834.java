package main.java;

public class Solution_2834 {
    public int minimumPossibleSum(int n, int target) {
        long cnt = Math.min(n, target / 2);
        return (int) (((cnt + 1) * cnt + (2L * target + n - cnt - 1) * (n - cnt)) / 2 % 1000000007);
    }
}
