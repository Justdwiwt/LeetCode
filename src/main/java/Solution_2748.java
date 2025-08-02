package main.java;

public class Solution_2748 {
    public int countBeautifulPairs(int[] nums) {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n - 1; i++)
            for (int j = i + 1; j < n; j++)
                if (gcd(getFirstNumber(nums[i]), nums[j] % 10) == 1)
                    count++;
        return count;
    }

    public int getFirstNumber(int x) {
        String s = String.valueOf(x);
        return s.charAt(0) - '0';
    }

    public int gcd(int a, int b) {
        return a % b == 0 ? b : gcd(b, a % b);
    }
}
