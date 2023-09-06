package main.java;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Solution_414 {
    public static int thirdMax(int[] nums) {
        Set<Integer> s = Arrays.stream(nums).boxed().collect(Collectors.toCollection(TreeSet::new));
        Object[] o = s.toArray();
        return s.size() < 3 ? (Integer) o[o.length - 1] : (Integer) o[o.length - 3];
    }
}
