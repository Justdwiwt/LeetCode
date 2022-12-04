package main.java;

import java.util.Arrays;

public class Solution_1491 {
    public double average(int[] salary) {
        return Arrays.stream(salary)
                .filter(num -> num > Arrays.stream(salary).min().getAsInt() && num < Arrays.stream(salary).max().getAsInt())
                .average()
                .getAsDouble();
    }
}
