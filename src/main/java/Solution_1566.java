package main.java;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_1566 {
    public boolean containsPattern(int[] arr, int m, int k) {
        List<Integer> list = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.toList());
        for (int i = 0; i <= list.size() - m * k; i++) {
            List<Integer> mkList = list.subList(i, i + m * k);
            List<Integer> mList = mkList.subList(0, m);
            List<Integer> _mkList = IntStream.rangeClosed(1, k).mapToObj(j -> mList).flatMap(Collection::stream).collect(Collectors.toList());
            if (_mkList.toString().equals(mkList.toString())) return true;
        }
        return false;
    }
}
