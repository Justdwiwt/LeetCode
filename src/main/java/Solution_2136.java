package main.java;

import java.util.Arrays;

public class Solution_2136 {
    static class Pair {
        int pt, gt;

        Pair(int pt, int gt) {
            this.pt = pt;
            this.gt = gt;
        }
    }

    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        Pair[] arr = new Pair[plantTime.length];
        Arrays.setAll(arr, i -> new Pair(plantTime[i], growTime[i]));
        Arrays.sort(arr, (a, b) -> b.gt - a.gt);
        int pt = 0;
        int maximumTime = Integer.MIN_VALUE;
        for (Pair pair : arr) {
            pt += pair.pt;
            maximumTime = Math.max(maximumTime, pt + pair.gt);
        }
        return maximumTime;
    }
}
