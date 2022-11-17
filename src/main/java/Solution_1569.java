package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_1569 {
    private static final long[][] arr;
    private static final long M = (long) (1e9 + 7);

    static {
        arr = new long[1001][1001];
        IntStream.range(0, arr.length).forEach(i -> {
            arr[0][i] = 0;
            arr[i][0] = 1;
        });
        for (int i = 1; i < arr.length; i++)
            for (int j = 1; j <= i; j++)
                arr[i][j] = (arr[i - 1][j - 1] + arr[i - 1][j]) % M;
    }

    public int numOfWays(int[] nums) {
        List<Long> list = Arrays.stream(nums).mapToObj(num -> (long) num).collect(Collectors.toList());
        return (int) (f(list) - 1);
    }

    private long f(List<Long> list) {
        if (list.size() <= 2) return 1;
        List<Long> left = new ArrayList<>();
        List<Long> right = new ArrayList<>();
        IntStream.range(1, list.size()).mapToLong(list::get).forEach(num -> {
            if (num < list.get(0)) left.add(num);
            else right.add(num);
        });
        return f(left) % M * f(right) % M * arr[left.size() + right.size()][left.size()] % M;
    }
}
