package main.java;

import java.util.Arrays;

public class Solution_2011 {
    public static int finalValueAfterOperations(String[] operations) {
        return Arrays.stream(operations, 0, operations.length)
                .mapToInt(operation -> operation.charAt(1) == '+' ? 1 : -1)
                .sum();
    }
}
