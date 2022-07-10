package main.java;

import java.util.Arrays;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Solution_2148 {
    public int countElements(int[] nums) {
        TreeSet<Integer> sortedSet = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toCollection(TreeSet::new));

        return (int) Arrays.stream(nums)
                .filter(num -> sortedSet.lower(num) != null && sortedSet.higher(num) != null)
                .count();
    }
}
