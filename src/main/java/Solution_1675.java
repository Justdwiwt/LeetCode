package main.java;

import java.util.Arrays;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Solution_1675 {
    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> ts = Arrays.stream(nums)
                .mapToObj(num -> num % 2 == 0 ? num : num * 2)
                .collect(Collectors.toCollection(TreeSet::new));

        int cut = ts.last() - ts.first();
        while (cut > 0 && (ts.last() % 2 == 0)) {
            int value = ts.last();
            ts.remove(value);
            ts.add(value / 2);
            cut = Math.min(cut, ts.last() - ts.first());
        }
        return cut;
    }
}
