package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Solution_1630 {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<>();
        int m = l.length;
        IntStream.range(0, m).mapToObj(i -> Arrays.copyOfRange(nums, l[i], r[i] + 1)).forEach(a -> {
            if (check(a)) res.add(true);
            else res.add(false);
        });
        return res;
    }

    private boolean check(int[] a) {
        int n = a.length;
        if (n < 3) return true;
        Arrays.sort(a);
        int d = a[1] - a[0];
        return IntStream.range(2, n).noneMatch(i -> d != a[i] - a[i - 1]);
    }
}
