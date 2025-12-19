package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Solution_2951 {
    public List<Integer> findPeaks(int[] mountain) {
        List<Integer> list = new ArrayList<>();
        IntStream.range(1, mountain.length - 1).filter(i -> mountain[i - 1] < mountain[i] && mountain[i] > mountain[i + 1]).forEach(list::add);
        return list;
    }
}
