package main.java;

import java.util.Arrays;

public class Solution_2698 {
    public int punishmentNumber(int n) {
        return Arrays.stream(new int[]{1, 9, 10, 36, 45, 55, 82, 91, 99, 100, 235, 297, 369, 370, 379, 414, 657, 675, 703, 756, 792, 909, 918, 945, 964, 990, 991, 999, 1000})
                .filter(a -> a <= n)
                .map(a -> a * a)
                .sum();
    }
}
