package main.java;

public class Solution_2520 {
    public int countDigits(int num) {
        int res = 0;
        for (int n = num; n > 0; n /= 10)
            if (num % (n % 10) == 0) ++res;
        return res;
    }
}
