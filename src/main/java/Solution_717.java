package main.java;

public class Solution_717 {
    public boolean isOneBitCharacter(int[] bits) {
        int start = 0;
        while (start < bits.length - 1)
            if (bits[start] == 0) start++;
            else start += 2;
        return start == bits.length - 1;
    }
}
