package main.java;

public class Solution_2601 {
    public boolean primeSubOperation(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--)
            if (nums[i] > nums[i - 1]) {
            } else {
                int diff = nums[i - 1] - nums[i];
                nums[i - 1] -= minPrime(diff);
                if (nums[i - 1] <= 0) return false;

            }
        return true;
    }

    public int minPrime(int diff) {
        int num = diff + 1;
        while (!isPrime(num)) num++;
        return num;
    }

    public boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++)
            if (n % i == 0) return false;
        return true;
    }
}
