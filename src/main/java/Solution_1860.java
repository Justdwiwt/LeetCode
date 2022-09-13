package main.java;

public class Solution_1860 {
    public int[] memLeak(int memory1, int memory2) {
        int i = 1;
        while (i <= memory1 || i <= memory2) {
            if (memory1 < memory2) memory2 -= i;
            else memory1 -= i;
            i++;
        }
        return new int[]{i, memory1, memory2};
    }
}
