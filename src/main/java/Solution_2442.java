package main.java;

import java.util.Arrays;
import java.util.HashSet;

public class Solution_2442 {
    public int countDistinctIntegers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        Arrays.stream(nums).forEach(num -> {
            set.add(num);
            String s = num + "";
            set.add(Integer.parseInt(new StringBuilder(s).reverse().toString()));
        });
        return set.size();
    }
}
