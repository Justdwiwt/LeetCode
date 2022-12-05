package main.java;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

public class Solution_1488 {
    public int[] avoidFlood(int[] rains) {
        int[] res = new int[rains.length];
        Map<Integer, Integer> waterMap = new HashMap<>();
        BitSet bs = new BitSet();
        for (int i = 0; i < rains.length; ++i)
            if (rains[i] > 0) {
                if (waterMap.get(rains[i]) != null) {
                    int next = bs.nextSetBit(waterMap.get(rains[i]) + 1);
                    if (next != -1) {
                        bs.set(next, false);
                        res[next] = rains[i];
                    } else return new int[0];
                }
                waterMap.put(rains[i], i);
                res[i] = -1;
            } else {
                res[i] = 1;
                bs.set(i);
            }
        return res;
    }
}
