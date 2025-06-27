package main.java;

import java.util.Arrays;

public class Solution_2683 {
    public boolean doesValidArrayExist(int[] derived) {
        int memo = Arrays.stream(derived).reduce(0, (a, b) -> a ^ b);
        return memo == 0;
    }
}
