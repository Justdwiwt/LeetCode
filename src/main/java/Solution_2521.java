package main.java;

public class Solution_2521 {
    public int distinctPrimeFactors(int[] nums) {
        boolean[] has = new boolean[1005];
        int ans = 0;
        for (int a : nums) {
            for (int i = 2; i * i <= a; i++)
                if (a % i == 0) {
                    if (!has[i]) ans++;
                    has[i] = true;
                    while (a % i == 0) a /= i;
                }
            if (a > 1 && !has[a]) ans++;
            has[a] = true;
        }
        return ans;
    }
}
