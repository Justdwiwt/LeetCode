package main.java;

import java.util.Arrays;

public class Solution_1894 {
    public int chalkReplacer(int[] chalk, int k) {
        long sum = Arrays.stream(chalk).asLongStream().sum();
        k = (int) (k % sum);
        for (int i = 0; i < chalk.length; i++) {
            k -= chalk[i];
            if (k < 0) return i;
        }
        return -1;
    }
}
