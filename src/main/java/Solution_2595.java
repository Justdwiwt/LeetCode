package main.java;

public class Solution_2595 {
    public int[] evenOddBit(int n) {
        int even = 0, odd = 0;
        for (int i = 0; i < 30; i++)
            if ((n & (1 << i)) != 0) {
                if ((i & 1) == 0) even++;
                else odd++;
            }
        return new int[]{even, odd};
    }
}
