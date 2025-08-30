package main.java;

import java.util.Arrays;

public class Solution_2798 {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        return Arrays.stream(hours).map(h -> h >= target ? 1 : 0).sum();
    }
}
