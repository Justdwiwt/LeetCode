package main.java;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        return IntStream.rangeClosed(left, right)
                .filter(Solution_728::isDivisor)
                .boxed()
                .collect(Collectors.toList());
    }

    private static boolean isDivisor(int num) {
        int n = num;
        while (num != 0) {
            if (num % 10 == 0 || n % (num % 10) != 0) return false;
            num /= 10;
        }
        return true;
    }
}
