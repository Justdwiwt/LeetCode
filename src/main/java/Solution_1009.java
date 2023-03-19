package main.java;

public class Solution_1009 {
    public int bitwiseComplement(int N) {
        int num = 1;
        while (num < N) num = (num << 1) + 1;
        return N ^ num;
    }
}
