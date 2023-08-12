package main.java;

import java.util.Arrays;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Solution_475 {
    public int findRadius(int[] houses, int[] heaters) {
        TreeSet<Integer> set = Arrays.stream(heaters).boxed().collect(Collectors.toCollection(TreeSet::new));
        int res = 0;
        for (int i : houses)
            if (!set.contains(i)) {
                int min = Integer.MAX_VALUE;
                if (set.lower(i) != null) min = Math.min(min, i - set.lower(i));
                if (set.higher(i) != null) min = Math.min(min, set.higher(i) - i);
                res = Math.max(res, min);
            }
        return res;
    }
}
