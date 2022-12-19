package main.java;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution_1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        if (candies.length == 0) return Collections.emptyList();
        int max = Arrays.stream(candies).max().getAsInt();
        return Arrays.stream(candies).boxed().map(t -> t + extraCandies >= max).collect(Collectors.toList());
    }
}
