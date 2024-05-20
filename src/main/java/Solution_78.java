package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution_78 {
    public List<List<Integer>> subsets(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .reduce(
                        Stream.of(new ArrayList<Integer>()).collect(Collectors.toList()),
                        (res, num) -> {
                            List<List<Integer>> newSubsets = res.stream()
                                    .map(subset -> {
                                        List<Integer> newSubset = new ArrayList<>(subset);
                                        newSubset.add(num);
                                        return newSubset;
                                    })
                                    .collect(Collectors.toList());
                            res.addAll(newSubsets);
                            return res;
                        },
                        (a, b) -> {
                            a.addAll(b);
                            return a;
                        }
                );
    }
}
