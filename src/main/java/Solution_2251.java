package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Solution_2251 {
    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        List<int[]> times = new ArrayList<>();
        Arrays.stream(flowers).forEach(flower -> {
            times.add(new int[]{flower[0], 1, 0});
            times.add(new int[]{flower[1], -1, 0});
        });
        IntStream.range(0, persons.length).mapToObj(i -> new int[]{persons[i], 0, i}).forEach(times::add);
        times.sort((a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int cur = 0;
        int[] res = new int[persons.length];
        for (int[] time : times)
            if (time[1] == 0) res[time[2]] = cur;
            else cur += time[1];
        return res;
    }
}
