package main.java;

public class Solution_2584 {
    public int findValidSplit(int[] nums) {
        int maxIndex = 0;
        for (int i = 0; i <= maxIndex; i++)
            for (int j = maxIndex; j < nums.length; j++)
                if (!gcd(nums[i], nums[j])) maxIndex = j;
        return maxIndex == nums.length - 1 ? -1 : maxIndex;
    }

    public boolean gcd(int m, int n) {
        int t = m % n;
        while (t != 0) {
            m = n;
            n = t;
            t = m % n;
        }
        return n == 1;
    }
}
