package main.java;

public class Solution_476 {
    public int findComplement(int num) {
        int n = 0;
        int a = num;
        while (num != 0) {
            n = n * 2 + 1;
            num = num / 2;
        }
        return n - a;
    }
}
