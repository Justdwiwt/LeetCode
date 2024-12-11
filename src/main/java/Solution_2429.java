package main.java;

public class Solution_2429 {
    public int minimizeXor(int num1, int num2) {
        int c1 = Integer.bitCount(num1);
        int c2 = Integer.bitCount(num2);
        for (; c2 < c1; ++c2) num1 &= num1 - 1;
        for (; c2 > c1; --c2) num1 |= num1 + 1;
        return num1;
    }
}
