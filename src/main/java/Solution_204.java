package main.java;

public class Solution_204 {
    public int countPrimes(int n) {
        int cnt = 0;
        boolean[] flag = new boolean[n];
        for (int i = 2; i < n; i++)
            if (!flag[i]) {
                cnt++;
                for (int j = i + i; j < n; j += i)
                    flag[j] = true;
            }
        return cnt;
    }
}
